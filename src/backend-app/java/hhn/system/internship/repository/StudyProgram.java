package hhn.system.internship.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
public class StudyProgram implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String degreeProgramName;
    private String description;
    private String academicDegree;
    private Integer numberOfSemesters;
    private String programRegulations;
    private Integer requiredECTSBasic;
    private Integer requiredECTSTotal;

    @ManyToOne
    private InternshipOfficeManager internshipOfficeManagers;

    @ManyToMany
    @JoinTable(
            name = "study_program_overall_process",
            joinColumns = @JoinColumn(name = "study_program_id"),
            inverseJoinColumns = @JoinColumn(name = "overall_process_id")
    )
    private List<OverallProcess> overallProcesses = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "study_program_secretary",
            joinColumns = @JoinColumn(name = "study_program_id"),
            inverseJoinColumns = @JoinColumn(name = "secretary_id")
    )
    private List<Secretary> secretaries = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "study_program_student",
            joinColumns = @JoinColumn(name = "study_program_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )


    private List<Student> students = new ArrayList<>();


    @Override
    public String toString() {
        return "Studiengang{" +
                "id=" + getId() +
                ", Studiengangname ='" + getDegreeProgramName() + '\'' +
                ", Beschreibung=" + getDescription() +
                ", Abschluss='" + getAcademicDegree() + '\'' +
                ", Anzahl Semester=" + getNumberOfSemesters() +
                ", Prüfungsverordnung='" + getProgramRegulations() + '\'' +
                ", Benötigte ECTS Grundstudium='" + getRequiredECTSBasic() + '\'' +
                ", Benötigte ECTS ='" + getRequiredECTSTotal() + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long iD) {
        this.id = iD;
    }

    public String getDegreeProgramName() {
        return degreeProgramName;
    }

    public void setDegreeProgramName(String degreeProgramName) {
        this.degreeProgramName = degreeProgramName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAcademicDegree() {
        return academicDegree;
    }

    public void setAcademicDegree(String academicDegree) {
        this.academicDegree = academicDegree;
    }

    public Integer getNumberOfSemesters() {
        return numberOfSemesters;
    }

    public void setNumberOfSemesters(Integer numberOfSemesters) {
        this.numberOfSemesters = numberOfSemesters;
    }

    public String getProgramRegulations() {
        return programRegulations;
    }

    public void setProgramRegulations(String programRegulations) {
        this.programRegulations = programRegulations;
    }

    public Integer getRequiredECTSBasic() {
        return requiredECTSBasic;
    }

    public void setRequiredECTSBasic(Integer requiredECTSBasic) {
        this.requiredECTSBasic = requiredECTSBasic;
    }

    public Integer getRequiredECTSTotal() {
        return requiredECTSTotal;
    }

    public void setRequiredECTSTotal(Integer requiredECTSTotal) {
        this.requiredECTSTotal = requiredECTSTotal;
    }

    public InternshipOfficeManager getInternshipOfficeManagers() {
        return internshipOfficeManagers;
    }

    public void setInternshipOfficeManagers(InternshipOfficeManager internshipOfficeManagers) {
        this.internshipOfficeManagers = internshipOfficeManagers;
    }

    public List<OverallProcess> getOverallProcesses() {
        return overallProcesses;
    }

    public void setOverallProcesses(List<OverallProcess> overallProcesses) {
        this.overallProcesses = overallProcesses;
    }

    public List<Secretary> getSecretaries() {
        return secretaries;
    }

    public void setSecretaries(List<Secretary> secretaries) {
        this.secretaries = secretaries;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}


