package hhn.system.internship.repository.organisation;

import hhn.system.internship.repository.Student;
import hhn.system.internship.repository.StudyProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudyProgramRepository extends JpaRepository<StudyProgram, Long> {

    @Query("SELECT s FROM StudyProgram sp JOIN sp.students s WHERE s.currentSemester = :semester")
    List<Student> findStudentsBySemester(@Param("semester") int semester);
}





