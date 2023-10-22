package project02.rest.entity;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherStudentDTO {
    String name;
    String surname;
    String profileImg;
    String position;
    String department;
    String username;
    String password;
    List<Student> advisee;
}
