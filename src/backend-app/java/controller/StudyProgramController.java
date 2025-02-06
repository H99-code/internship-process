package controller;

import hhn.system.internship.repository.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.StudyProgramService;

import java.util.List;

@RestController
@RequestMapping("/api/study-programs")
public class StudyProgramController {
    private final StudyProgramService studyProgramService;

    public StudyProgramController(StudyProgramService studyProgramService) {
        this.studyProgramService = studyProgramService;
    }

    @GetMapping("/students/semester/{semester}")
    public List<Student> getStudentsBySemester(@PathVariable int semester) {
        return studyProgramService.getStudentsBySemester(semester);
    }
}
