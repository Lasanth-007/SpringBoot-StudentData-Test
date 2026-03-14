package learn.student.school;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import learn.student.student.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @OneToMany(
            mappedBy = "school",
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Student> studentList;
}
