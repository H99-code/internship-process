package hhn.system.internship.repository.person;

import hhn.system.internship.repository.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {
}
