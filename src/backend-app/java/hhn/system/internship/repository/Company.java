package hhn.system.internship.repository;

import jakarta.persistence.*;


@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String companyAddress;


    private String contactPerson;


    private String contactEmail;


    private String contactPhoneNumber;



    @Column(length = 1000)
    private String companyDescription;


    private String companyName;


    @OneToOne()
    @JoinColumn(name = "overall_process_id", referencedColumnName = "id")
    private OverallProcess overallProcess;


    @Override
    public String toString() {
        return "Firma{" +
                "id=" + getId() +
                ", Firmenadresse='" + getCompanyAddress() + '\'' +
                ", Kontaktperson=" + getContactPerson() +
                ", Kontakt-E-Mail='" + getContactEmail() + '\'' +
                ", Stellenbeschreibung='" + getCompanyDescription() + '\'' +
                ", Firmenname='" + getCompanyName() + '\'' +
                ", Kontakttelefonnummer=" + getContactPhoneNumber() +
                '}';

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }


    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public OverallProcess getOverallProcess() {
        return overallProcess;
    }

    public void setOverallProcess(OverallProcess overallProcess) {
        this.overallProcess = overallProcess;
    }

}

