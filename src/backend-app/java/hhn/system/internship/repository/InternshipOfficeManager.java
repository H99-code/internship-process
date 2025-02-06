package hhn.system.internship.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;


@Entity
public class InternshipOfficeManager extends Person {

    @ManyToOne
    private StudyProgram studyProgram;


    public StudyProgram getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(StudyProgram studyProgram) {
        this.studyProgram = studyProgram;
    }

    @Override
    public String toString() {
        return "Praktikantenamtsleiter{" +
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
                ", Matrikelnummer=" + studyProgram +
                '}';
    }
}

