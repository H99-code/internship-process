package hhn.system.internship.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iD;

    private String description;
    private String taskName;
    private LocalDateTime dueDate;
    private LocalDateTime creationDate;


    @Enumerated(EnumType.STRING)
    private Role assignedRole;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToMany
    @JoinTable(
            name = "task_document",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "document_id")
    )
    private List<Document> documents = new ArrayList<>();


    @ManyToMany
    @JoinTable(
            name = "task_process_instance",
            joinColumns = @JoinColumn(name = "task_id"),
            inverseJoinColumns = @JoinColumn(name = "process_instance_id")
    )
    private List<ProcessInstance> processInstances = new ArrayList<>();


    @Override
    public String toString() {
        return "Aufgaben{" +
                "id=" + getId() +
                ", Aufgabenbeschreibung ='" + getDescription() + '\'' +
                ", Aufgabenname=" + getTaskName() +
                ", Fristdatum ='" + getDueDate() + '\'' +
                ", Erstellungsdatum=" + getCreationDate() +
                ", Zugewiesene Rolle ='" + getAssignedRole() + '\'' +
                ", Status ='" + getStatus() + '\'' +

                '}';
    }


    public Long getId() {
        return iD;
    }

    public void setId(Long iD) {
        this.iD = iD;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Role getAssignedRole() {
        return assignedRole;
    }

    public void setAssignedRole(Role assignedRole) {
        this.assignedRole = assignedRole;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public List<ProcessInstance> getProcessInstances() {
        return processInstances;
    }

    public void setProcessInstances(List<ProcessInstance> processInstances) {
        this.processInstances = processInstances;
    }
}


