package hhn.system.internship.repository;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String examName;


    private String examStatus;


    private Integer examNumber;


    private String examECTS;


    @ManyToOne
    @JoinColumn(name = "study_achievement_id", referencedColumnName = "id")
    private StudyAchievement studyAchievement;

    @Override
    public String toString() {
        return "Prüfungen{" +
                "id=" + getId() +
                ", Prüfungsname='" + getExamName() + '\'' +
                ", Prüfungsstatus='" + getExamStatus() + '\'' +
                ", Prüfungsnummer='" + getExamNumber() + '\'' +
                ", Ects ='" + getExamECTS() + '\'' +
                '}';
    }


    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getExamName() {

        return examName;
    }

    public void setExamName(String examName) {

        this.examName = examName;
    }

    public String getExamStatus() {

        return examStatus;
    }

    public void setExamStatus(String examStatus) {
        this.examStatus = examStatus;
    }

    public Integer getExamNumber() {
        return examNumber;
    }

    public void setExamNumber(Integer examNumber) {
        this.examNumber = examNumber;
    }

    public String getExamECTS() {
        return examECTS;
    }

    public void setExamECTS(String examECTS) {

        this.examECTS = examECTS;
    }

    public StudyAchievement getStudyAchievement() {

        return studyAchievement;
    }


    public void setStudyAchievement(StudyAchievement studyAchievement) {
        this.studyAchievement = studyAchievement;
    }
}
