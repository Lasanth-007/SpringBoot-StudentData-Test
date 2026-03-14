package learn.student.school;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchRepository extends JpaRepository<School,Long> {
}
