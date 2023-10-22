package project02.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import project02.rest.security.user.User;

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
    Long id;
    String firstname;
    String lastname;
    @ElementCollection
    List<String> profileImg;
    String position;
    String department;
    @OneToMany(mappedBy = "advisor")
    @Builder.Default
    List<Student> advisee = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
