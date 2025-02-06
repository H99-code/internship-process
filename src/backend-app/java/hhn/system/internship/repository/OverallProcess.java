package hhn.system.internship.repository;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
public class OverallProcess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime registrationDeadline;
    private String processName;

    @OneToMany(mappedBy = "overallProcess")
    public List<ProcessInstance> processInstances = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "study_program_id")
    public StudyProgram studyProgram;

    @ManyToOne
    public Company company;


    @OneToMany(mappedBy = "overallProcess")
    public List<Student> students = new ArrayList<>();

    @Override
    public String toString() {
        return "Gesamtprozess{" +
                "id=" + getId() +
                ", Status='" + getStatus() + '\'' +
                ", Startdatum='" + getStartDate() + '\'' +
                ", Enddatum='" + getEndDate() + '\'' +
                ", Anmeldefrist ='" + getRegistrationDeadline() + '\'' +
                ", Prozessname ='" + getProcessName() + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getRegistrationDeadline() {
        return registrationDeadline;
    }

    public void setRegistrationDeadline(LocalDateTime registrationDeadline) {
        this.registrationDeadline = registrationDeadline;
    }

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }
}
