package service;

import hhn.system.internship.repository.Student;
import hhn.system.internship.repository.organisation.StudyProgramRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyProgramService {
    private final StudyProgramRepository studyProgramRepository;

    public StudyProgramService(StudyProgramRepository studyProgramRepository) {
        this.studyProgramRepository = studyProgramRepository;
    }

    public List<Student> getStudentsBySemester(int semester) {
        return studyProgramRepository.findStudentsBySemester(semester);
    }
}
