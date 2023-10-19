package project02.rest.event;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Student {
    Long studentId;
    String name;
    String surname;
    String profileImg;
    String department;
}
