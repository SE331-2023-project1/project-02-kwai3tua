package project02.rest.entity;

import jakarta.persistence.*;
import lombok.*;
import project02.rest.security.user.User;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    Long studentId;
    @ElementCollection
    List<String> profileImg;
    String department;
    @ManyToOne
    Teacher advisor;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
