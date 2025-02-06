package hhn.system.internship.repository;

import hhn.system.internship.repository.organisation.CompanyRepository;
import hhn.system.internship.repository.organisation.DocumentRepository;
import hhn.system.internship.repository.organisation.StudyProgramRepository;
import hhn.system.internship.repository.person.*;
import hhn.system.internship.repository.process.OverallProcessRepository;
import hhn.system.internship.repository.process.ProcessInstanceRepository;
import hhn.system.internship.repository.process.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class PracticalSemesterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticalSemesterApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(StudentRepository studentRepository, InternshipOfficeManagerRepository internshipOfficeManagerRepository, StudyProgramRepository studyProgramRepository,
                                  SecretaryRepository secretaryRepository, CompanyRepository companyRepository, TaskRepository taskRepository, DocumentRepository documentRepository, StudyAchievementRepository studyAchievementRepository
    , OverallProcessRepository overallProcessRepository, ProcessInstanceRepository processInstanceRepository, ExamRepository examRepository) {
        return _ -> {


            Student student = new Student();
            student.setStudyProgram("AI");
            student.setStudentStatus("zugelassen");
            student.setPhase("Im Praxissemester");
            student.setCurrentSemester(4);
            student.setName("Student 1");


            studentRepository.save(student);
            System.out.println("Alle Studenten: " + studentRepository.findAll());
            Optional<Student> optionalStudent = studentRepository.findById(1L);
            optionalStudent.ifPresent(students -> {
                        System.out.println("Gefundener Student: " + students);
                    });





                InternshipOfficeManager internshipOfficeManager = new InternshipOfficeManager();
                internshipOfficeManager.setFirstName("Peter");
                internshipOfficeManager.setLastName("Praxissemester");
                internshipOfficeManagerRepository.save(internshipOfficeManager);
                System.out.println("Alle PL: " + internshipOfficeManagerRepository.findAll());

                Optional<InternshipOfficeManager> optionalInternshipOfficeManager = internshipOfficeManagerRepository.findById(1L);
                optionalInternshipOfficeManager.ifPresent(internshipOfficeManagers -> {
                            System.out.println("Gefundener InternshipOfficeManager: " + internshipOfficeManagers);
                        });


                    StudyProgram studyProgram = new StudyProgram();
                    studyProgram.setAcademicDegree("Bachelor");
                    studyProgram.setDescription("Studiengang für AI");
                    studyProgram.setProgramRegulations("SPO2");
                    studyProgram.setDegreeProgramName("Angewandte Informatik");
                    studyProgram.setRequiredECTSBasic(60);
                    studyProgram.setRequiredECTSTotal(210);



                    studyProgramRepository.save(studyProgram);
                    System.out.println("Alle Studiengänge: " + studyProgramRepository.findAll());
                    Optional<StudyProgram> optionalStudyProgram = studyProgramRepository.findById(1L);
                    optionalStudyProgram.ifPresent(studyPrograms -> {


                                System.out.println("Gefundener Studiengang: " + studyPrograms);
                            });

                        Secretary secretary = new Secretary();
                        secretary.setFirstName("Sara");
                        secretary.setLastName("Aba");
                        secretary.setPhoneNumber(12344);
                        secretaryRepository.save(secretary);
                        System.out.println("Alle Sekretariate: " + secretaryRepository.findAll());


                        Optional<Secretary> optionalSecretary = secretaryRepository.findById(1L);
                        optionalSecretary.ifPresent(secretarys -> {
                            System.out.println("Gefundenes Sekretariat: " + secretarys);
                        });


                        Company company = new Company();
                        company.setCompanyAddress("Heilbronn");
                        company.setCompanyName("GECKO");
                        company.setContactEmail("contact@gmail.com");
                        companyRepository.save(company);
                        System.out.println("Alle Firmen: " + secretaryRepository.findAll());

                      Optional<Optional<Company>> optionalCompany = Optional.ofNullable(companyRepository.findById(1L));
                       optionalCompany.ifPresent(companys -> {
                       System.out.println("Gefundenene Firma: " + companys);
                     });

                       Task task = new Task();
                       task.setAssignedRole(Role.STUDENT);
                       task.setTaskName("Antrag ausfüllen");
                       task.setDescription("Antrag auf Zulassung");
                       task.setStatus(Status.OFFEN);

                       taskRepository.save(task);
                       System.out.println("Alle Aufgaben: " + taskRepository.findAll());

                      Optional<Task> optionalTask = taskRepository.findById(1L);
                      optionalTask.ifPresent(tasks -> {
                      System.out.println("Gefundenene Firma: " + tasks);
                      });


                      Document document = new Document();
                      document.setFileName("Antrag auf Zulassung");
                      document.setStatus(Status.OFFEN);

                      documentRepository.save(document);
                      System.out.println("Alle Dokumente: " + taskRepository.findAll());

            Optional<Document> optionalDocument = documentRepository.findById(1L);
            optionalDocument.ifPresent(documents -> {
                System.out.println("Gefundenenes Dokument: " + documents);
            });

            StudyAchievement studyAchievement = new StudyAchievement();
            studyAchievement.setBasicStatus("Zugelassen");
            studyAchievement.setCurrentECTSBasic(60);
            studyAchievementRepository.save(studyAchievement);
            System.out.println("Alle Studienleistungen: " + studyAchievementRepository.findAll());

            Optional<StudyAchievement> optionalStudyAchievement = studyAchievementRepository.findById(1L);
            optionalStudyAchievement.ifPresent(studyAchievements -> {
                System.out.println("Gefundenene Studienleistung: " + studyAchievements);
            });



            OverallProcess overallProcess = new OverallProcess();
            overallProcess.setProcessName("Praxissemester");
            overallProcess.setStatus(Status.OFFEN);
            overallProcessRepository.save(overallProcess);
            System.out.println("Alle Prozesse: " + overallProcessRepository.findAll());


            Optional<OverallProcess> optionalOverallProcess = overallProcessRepository.findById(1L);
            optionalOverallProcess.ifPresent(overallProcesses -> {
                System.out.println("Gefundenener Prozess: " + overallProcesses);
            });


            ProcessInstance processInstance = new ProcessInstance();
            processInstance.setStatus(Status.OFFEN);
            processInstance.setProcessInstanceName("Anmeldeprozess");


            processInstanceRepository.save(processInstance);
            System.out.println("Alle Prozessinstanzen: " + processInstanceRepository.findAll());

            Optional<ProcessInstance> optionalProcessInstance = processInstanceRepository.findById(1L);
            optionalProcessInstance.ifPresent(processInstances -> {
                System.out.println("Gefundenene Prozessinstanz: " + processInstances);
            });
            Exam exam = new Exam();
            exam.setExamName("Prüfung");
            exam.setExamNumber(12345);
            examRepository.save(exam);
            System.out.println("Alle Prüfungen: " + examRepository.findAll());


            Optional<Exam> optionalExam = examRepository.findById(1L);
            optionalExam.ifPresent(exams -> {
                System.out.println("Gefundenene Prüfungen: " + exams);
            });
        };
    }
}


