package project02.rest.security.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project02.rest.security.user.Role;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("refresh_token")
  private String refreshToken;
  @JsonProperty("user_role")
  private List<Role> userRole;
  @JsonProperty("user_username")
  private String userName;

  @JsonProperty("user_id")
  private Integer id;

  @JsonProperty("student_id")
  private Long studentId;

  @JsonProperty("teacher_id")
  private Long teacherId;

  public static AuthenticationResponse successStudent(String accessToken, String refreshToken, List<Role> userRole, Long studentId) {
    return AuthenticationResponse.builder()
            .accessToken(accessToken)
            .refreshToken(refreshToken)
            .userRole(userRole)
            .studentId(studentId)
            .build();
  }
}
