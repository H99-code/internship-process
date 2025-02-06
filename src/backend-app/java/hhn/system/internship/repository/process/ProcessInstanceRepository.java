package hhn.system.internship.repository.process;

import hhn.system.internship.repository.ProcessInstance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessInstanceRepository extends JpaRepository<ProcessInstance, Long> {
}
