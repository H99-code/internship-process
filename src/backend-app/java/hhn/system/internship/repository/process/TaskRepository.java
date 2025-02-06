package hhn.system.internship.repository.process;


import hhn.system.internship.repository.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
