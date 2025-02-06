package hhn.system.internship.repository;

import hhn.system.internship.repository.organisation.CompanyRepository;
import hhn.system.internship.repository.organisation.DocumentRepository;
import hhn.system.internship.repository.organisation.StudyProgramRepository;
import hhn.system.internship.repository.person.*;
import hhn.system.internship.repository.process.OverallProcessRepository;
import hhn.system.internship.repository.process.ProcessInstanceRepository;
import hhn.system.internship.repository.process.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class PracticalSemesterService {

    private final StudentRepository studentRepository;
    private final InternshipOfficeManagerRepository internshipOfficeManagerRepository;
    private final SecretaryRepository secretaryRepository;
    private final TaskRepository taskRepository;
    private final OverallProcessRepository overallProcessRepository;
    private final StudyProgramRepository studyProgramRepository;
    private final CompanyRepository companyRepository;
    private final DocumentRepository documentRepository;
    private final ProcessInstanceRepository processInstanceRepository;
    private final StudyAchievementRepository studyAchievementRepository;
    private final ExamRepository examRepository;

    public PracticalSemesterService(StudentRepository studentRepository, InternshipOfficeManagerRepository internshipOfficeManagerRepository, SecretaryRepository secretaryRepository, TaskRepository taskRepository
            , OverallProcessRepository overallProcessRepository, StudyProgramRepository studyProgramRepository, CompanyRepository companyRepository, DocumentRepository documentRepository,
                                    ProcessInstanceRepository processInstanceRepository, StudyAchievementRepository studyAchievementRepository, ExamRepository examRepository) {
        this.studentRepository = studentRepository;
        this.internshipOfficeManagerRepository = internshipOfficeManagerRepository;
        this.secretaryRepository = secretaryRepository;
        this.taskRepository = taskRepository;
        this.overallProcessRepository = overallProcessRepository;
        this.studyProgramRepository = studyProgramRepository;
        this.companyRepository = companyRepository;
        this.documentRepository = documentRepository;
        this.processInstanceRepository = processInstanceRepository;
        this.studyAchievementRepository = studyAchievementRepository;
        this.examRepository = examRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public InternshipOfficeManager createInternshipOfficeManager(InternshipOfficeManager internshipOfficeManager) {
        return internshipOfficeManagerRepository.save(internshipOfficeManager);
    }

    public Secretary createSecretary(Secretary secretary) {
        return secretaryRepository.save(secretary);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public OverallProcess createOverallProcess(OverallProcess overallProcess) {
        return overallProcessRepository.save(overallProcess);
    }

    public StudyProgram createStudyProgram(StudyProgram studyProgram) {
        return studyProgramRepository.save(studyProgram);
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    public ProcessInstance createProcessInstance(ProcessInstance processInstance) {
        return processInstanceRepository.save(processInstance);
    }

    public StudyAchievement createStudyAchievementRepository(StudyAchievement studyAchievement) {
        return studyAchievementRepository.save(studyAchievement);
    }

    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }


}

