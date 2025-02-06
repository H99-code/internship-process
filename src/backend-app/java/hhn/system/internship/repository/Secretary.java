package hhn.system.internship.repository;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Secretary extends Person {

    private Integer phoneNumber;

    @ManyToOne
    private StudyProgram studyProgram;


    @Override
    public String toString() {
        return "Sekretariat{" +
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
                ", Matrikelnummer=" + phoneNumber +
                '}';
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StudyProgram getStudyProgram() {
        return studyProgram;
    }

    public void setStudyProgram(StudyProgram studyProgram) {
        this.studyProgram = studyProgram;
    }

}
