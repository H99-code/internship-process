package hhn.system.internship.repository.person;

import hhn.system.internship.repository.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SecretaryRepository extends JpaRepository<Secretary, Long> {


    List<Secretary> findByStudyProgramId(Long studyProgramId);


    Secretary findByStudyProgramIdAndId(Long studyProgramId, Long id);
}
