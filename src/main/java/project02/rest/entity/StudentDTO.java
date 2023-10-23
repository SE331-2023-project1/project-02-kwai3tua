package project02.rest.entity;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    Long id;
    String image;
    String department;
    String email;
    TeacherBriefDTO teacher;
    String username;
    String firstname;
    String lastname;
}
