package project02.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long Id;
    String name;
    String surname;
    String profileImg;
    String position;
    String department;
    String username;
    String password;
    @OneToMany(mappedBy = "advisor")
    @Builder.Default
    List<Student> advisee = new ArrayList<>();
}
