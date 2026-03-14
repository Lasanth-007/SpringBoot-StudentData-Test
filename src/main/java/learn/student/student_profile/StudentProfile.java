package learn.student.student_profile;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import learn.student.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;
    private String bio;
    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    @JsonBackReference
    Student student;


}
