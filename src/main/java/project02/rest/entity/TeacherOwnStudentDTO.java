package project02.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherOwnStudentDTO {
    Long id;
    String firstname;
    String lastname;
    String image;
    String email;
}
