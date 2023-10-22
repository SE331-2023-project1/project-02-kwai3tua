package project02.rest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentTeacherDTO {
    Long id;
    String academicPosition;
    String firstname;
    String surname;
    String department;
    String images;
}