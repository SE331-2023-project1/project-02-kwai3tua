package project02.rest.entity;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    Long id;
    Long Id;
    Long studentId;
    String name;
    String surname;
    String profileImg;
    String department;
    StudentTeacherDTO advisor;
}
