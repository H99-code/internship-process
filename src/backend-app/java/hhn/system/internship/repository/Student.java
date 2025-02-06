package hhn.system.internship.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Person {

    private String name;
    private Integer studentNumber;
    private Integer currentSemester;
    private String studyProgram;
    private String phase;
    private String studentStatus;

    public String getStudentStatus(){
        return studentStatus;
    }
    public void setStudentStatus(String studentStatus){
        this.studentStatus = studentStatus;
    }

    @JsonProperty("studyAchievements")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StudyAchievement> studyAchievementList;


    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    private OverallProcess overallProcess;


    @ManyToOne
    @JoinColumn(name = "academic_achievement_id")
    private StudyAchievement academicAchievement;


    @ManyToMany
    @JoinTable(
            name = "student_study_programs",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "study_program_id")
    )


    private List<StudyProgram> studyPrograms = new ArrayList<>();


    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", Vorname='" + getFirstName() + '\'' +
                ", Nachname='" + getLastName() + '\'' +
                ", Geschlecht='" + getGender() + '\'' +
                ", Email ='" + getEmailAddress() + '\'' +
                ", Rolle ='" + getRoles() + '\'' +
                ", Raumnummer='" + getRoomNumber() + '\'' +
                ", Personalnummer='" + getPersonalNumber() + '\'' +
                ", Verfügbarkeit='" + getAvailability() + '\'' +
                ", Akademischer Titel='" + getAcademicTitle() + '\'' +
                ", Matrikelnummer=" + studentNumber +
                ", Fachsemester='" + currentSemester + '\'' +
                ", Status =" + status +
                '}';
    }


    public Integer getStudentNumber() {
        return studentNumber;
    }

    public String getPhase() {
        return phase;
    }
    public void setPhase(String phase) {
        this.phase = phase;
    }
    public void setStudentNumber(Integer studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Integer getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(Integer currentSemester) {
        this.currentSemester = currentSemester;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public OverallProcess getOverallProcess() {
        return overallProcess;
    }

    public void setOverallProcess(OverallProcess overallProcess) {
        this.overallProcess = overallProcess;
    }

    public StudyAchievement getAcademicAchievement() {
        return academicAchievement;
    }

    public void setAcademicAchievement(StudyAchievement academicAchievement) {
        this.academicAchievement = academicAchievement;
    }

    public List<StudyProgram> getStudyPrograms() {
        return studyPrograms;
    }

    public void setStudyPrograms(List<StudyProgram> studyPrograms) {
        this.studyPrograms = studyPrograms;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(String studyProgram) {
        this.studyProgram = studyProgram;
    }

    public List<StudyAchievement> getStudyAchievementList() {
        return studyAchievementList;
    }

    public void setStudyAchievementList(List<StudyAchievement> studyAchievementList) {
        this.studyAchievementList = studyAchievementList;
    }
}