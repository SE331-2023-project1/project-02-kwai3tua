package project02.rest.entity;

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
public class TeacherDTO {
    Long Id;
    List<String> images;
    String department;
    List<TeacherOwnStudentDTO> ownStudent = new ArrayList<>();
}
