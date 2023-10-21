package project02.rest.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long Id;
    Long studentId;
    String name;
    String surname;
    String profileImg;
    String department;
    @ManyToOne
    Teacher advisor;
}
