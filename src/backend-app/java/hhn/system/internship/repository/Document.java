package hhn.system.internship.repository;

import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Status status;


    private String fileName;


    private String filePath;


    private LocalDateTime uploadDate;

    private String uploadedFrom;
    private LocalDateTime dueDate;

    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private Task task;

    @Override
    public String toString() {
        return "Dokument{" +
                "id=" + getId() +
                ", Status ='" + getStatus() + '\'' +
                ", Dokumentname=" + getFileName() +
                ", Dokument Pfad='" + getFilePath() + '\'' +
                ", Hochgeladen am =" + getUploadDate() +
                ", Hochgeladen von='" + getUploadedFrom() + '\'' +
                ", Fälligkeitsdatum='" + getDueDate() + '\'' +
                ", Aufgabe ='" + getTask() + '\'' +
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public LocalDateTime getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(LocalDateTime uploadDate) {
        this.uploadDate = uploadDate;
    }

    public String getUploadedFrom() {
        return uploadedFrom;
    }

    public void setUploadedFrom(String uploadedFrom) {
        this.uploadedFrom = uploadedFrom;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}

