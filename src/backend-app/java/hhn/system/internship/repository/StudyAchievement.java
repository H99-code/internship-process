package hhn.system.internship.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.List;


@Entity
public class StudyAchievement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;

    @ManyToOne
    private Exam exam;
    private Integer currentECTSTotal;
    private Integer currentECTSBasic;

    private String basicStatus;
    private Integer requiredECTSBasic;


    @ManyToOne
    private Student student;



    @ManyToMany
    @JoinTable(
            name = "study_achievement_exams",
            joinColumns = @JoinColumn(name = "study_achievement_id"),
            inverseJoinColumns = @JoinColumn(name = "exam_id")
    )


    private List<Exam> exams;


    @Override
    public String toString() {
        return "Studienleistung{" +
                "id=" + getId() +
                ", Prüfung ='" + getExam() + '\'' +
                ", Aktuelle ECTS Grundstudium =" + getCurrentECTSBasic() +
                ", Aktuelle ECTS Insgesamt='" + getCurrentECTSTotal() + '\'' +
                ", Grundstudium Status=" + getBasicStatus() +
                ", Benötigte ECTS Grundstudium='" + getRequiredECTSBasic() + '\'' +
                ", Student ='" + getStudent() + '\'' +
                '}';
    }

    public Long getId() {
        return iD;
    }



    public void setId(Long iD) {
        this.iD = iD;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Integer getCurrentECTSTotal() {
        return currentECTSTotal;
    }

    public void setCurrentECTSTotal(Integer currentECTSTotal) {
        this.currentECTSTotal = currentECTSTotal;
    }

    public Integer getCurrentECTSBasic() {
        return currentECTSBasic;
    }

    public void setCurrentECTSBasic(Integer currentECTSBasic) {
        this.currentECTSBasic = currentECTSBasic;
    }

    public String getBasicStatus() {
        return basicStatus;
    }

    public void setBasicStatus(String basicStatus) {
        this.basicStatus = basicStatus;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }


    public Integer getRequiredECTSBasic() {
        return requiredECTSBasic;
    }

    public void setRequiredECTSBasic(Integer requiredECTSBasic) {
        this.requiredECTSBasic = requiredECTSBasic;
    }
}

