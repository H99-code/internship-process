package hhn.system.internship.repository;

import jakarta.persistence.*;


import java.time.LocalDateTime;


@Entity
public class ProcessInstance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String task;
    private String registrationProcess;
    private String executionProcess;
    private String endProcess;


    private String processInstanceName;

    @ManyToOne
    private OverallProcess overallProcess;

    @ManyToOne
    private Task taskEntity;

    @Override
    public String toString() {
        return "Prozessinstanz{" +
                "id=" + getId() +
                ", Status='" + getStatus() + '\'' +
                ", Startdatum='" + getStartTime() + '\'' +
                ", Enddatum='" + getEndTime() + '\'' +
                ", Aufgabe ='" + getTask() + '\'' +
                ", Anmeldeprozess ='" + getRegistrationProcess() + '\'' +
                ", Durchführungsprozess ='" + getExecutionProcess() + '\'' +
                ", Endprozess ='" + getEndProcess() + '\'' +
                ", Prozessinstanzname ='" + getProcessInstanceName() + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setiD(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getRegistrationProcess() {
        return registrationProcess;
    }

    public void setRegistrationProcess(String registrationProcess) {
        this.registrationProcess = registrationProcess;
    }

    public String getExecutionProcess() {
        return executionProcess;
    }

    public void setExecutionProcess(String executionProcess) {
        this.executionProcess = executionProcess;
    }

    public String getEndProcess() {
        return endProcess;
    }

    public void setEndProcess(String endProcess) {
        this.endProcess = endProcess;
    }

    public String getProcessInstanceName() {
        return processInstanceName;
    }

    public void setProcessInstanceName(String processInstanceName) {
        this.processInstanceName = processInstanceName;
    }

    public OverallProcess getOverallProcess() {
        return overallProcess;
    }

    public void setOverallProcess(OverallProcess overallProcess) {
        this.overallProcess = overallProcess;
    }

    public Task getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(Task taskEntity) {
        this.taskEntity = taskEntity;
    }
}


