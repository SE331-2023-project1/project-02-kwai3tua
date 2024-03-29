package com.se331.kwai3tua.security.auth;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.se331.kwai3tua.entity.Student;
import com.se331.kwai3tua.entity.Teacher;
import com.se331.kwai3tua.repository.StudentRepository;
import com.se331.kwai3tua.repository.TeacherRepository;
import com.se331.kwai3tua.security.config.JwtService;
import com.se331.kwai3tua.security.token.Token;
import com.se331.kwai3tua.security.token.TokenRepository;
import com.se331.kwai3tua.security.token.TokenType;
import com.se331.kwai3tua.security.user.Role;
import com.se331.kwai3tua.security.user.User;
import com.se331.kwai3tua.security.user.UserProfileDTO;
import com.se331.kwai3tua.security.user.UserRepository;
import com.se331.kwai3tua.util.CloudStorageHelper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;

    @Autowired
    private CloudStorageHelper cloudStorageHelper;
    public AuthenticationResponse studentRegister(RegisterRequest request) throws ServletException, IOException {
        if (repository.existsByUsername(request.getUsername())) {
            ErrorResponse errorResponse = new ErrorResponse(403,"Duplicate Username");
            return AuthenticationResponse.error(errorResponse);
        }
        User user = User.builder()
                .username(request.getUsername())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(Role.ROLE_STUDENT))
                .image(request.getImage())
                .build();

        if (request.getImage() == null) {
            user.setImage("https://pbs.twimg.com/profile_images/1321030814436655106/87OcbZNm_400x400.jpg");
        }
        var savedUser = repository.save(user);
        Student student = new Student();
        student.setUser(savedUser);
        studentRepository.save(student);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.successStudent(jwtToken, refreshToken, user.getRoles(),student.getId());
    }

    public AuthenticationResponse teacherRegister(RegisterRequest request) throws ServletException, IOException {

        if (repository.existsByUsername(request.getUsername())) {
            ErrorResponse errorResponse = new ErrorResponse(403,"Duplicate Username");
            return AuthenticationResponse.error(errorResponse);
        }
        User advisor = User.builder()
                .username(request.getUsername())
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(List.of(Role.ROLE_TEACHER))
                .image(request.getImage())
                .build();
        if (request.getImage() == null) {
            advisor.setImage("https://pbs.twimg.com/profile_images/1321030814436655106/87OcbZNm_400x400.jpg");
        }
        Teacher teacher = new Teacher();
        teacher.setUser(advisor);
        var savedUser = repository.save(advisor);
        teacherRepository.save(teacher);
        var jwtToken = jwtService.generateToken(advisor);
        var refreshToken = jwtService.generateRefreshToken(advisor);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.successTeacher(jwtToken, refreshToken, advisor.getRoles(), teacher.getId());
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        User user = repository.findByUsername(request.getUsername())
                .orElseThrow();

        Long teacherId = null;
        Long studentId = null;
        if (user.getTeacher() != null) {
            teacherId = user.getTeacher().getId();
        }
        if (user.getStudent() != null) {
            studentId = user.getStudent().getId();
        }
        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        List<Role> userRoles = user.getRoles();
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .userRole(userRoles)
                .userName(user.getUsername())
                .id(user.getId())
                .teacherId(teacherId)
                .studentId(studentId)
                .build();
    }

    public UserProfileDTO getCurrentUserProfile() {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println(currentUsername);
        User currentUser = repository.findByUsername(currentUsername).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        System.out.println(currentUsername);
        UserProfileDTO profile = new UserProfileDTO();
        profile.setUsername(currentUser.getUsername());
        profile.setFirstname(currentUser.getFirstname());
        profile.setLastname(currentUser.getLastname());
        profile.setEmail(currentUser.getEmail());
        return profile;
    }

    private void saveUserToken(User user, String jwtToken) {
        Token token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(User user) {
        List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            User user = this.repository.findByUsername(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                String accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                AuthenticationResponse authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}