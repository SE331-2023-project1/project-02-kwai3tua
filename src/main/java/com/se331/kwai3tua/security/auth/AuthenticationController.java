package com.se331.kwai3tua.security.auth;

import com.se331.kwai3tua.security.user.UserProfileDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/register/student")
  public ResponseEntity<AuthenticationResponse> studentRegister(
          @RequestBody RegisterRequest request
  ) throws ServletException, IOException {
    return ResponseEntity.ok(service.studentRegister(request));
  }

  @PostMapping("/register/teacher")
  public ResponseEntity<AuthenticationResponse> teacherRegister(
          @RequestBody RegisterRequest request
  ) throws ServletException, IOException {
    return ResponseEntity.ok(service.teacherRegister(request));
  }

  @PostMapping("/login")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    AuthenticationResponse result = service.authenticate(request);
    return ResponseEntity.ok(result);
  }

  @GetMapping("/profile")
  public ResponseEntity<UserProfileDTO> getProfile() {
    UserProfileDTO profile = service.getCurrentUserProfile();
    return ResponseEntity.ok(profile);
  }

  @PostMapping("/refresh-token")
  public void refreshToken(
      HttpServletRequest request,
      HttpServletResponse response
  ) throws IOException {
    service.refreshToken(request, response);
  }
}