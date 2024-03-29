package case_study.FuramaResort.model;

import java.util.Date;

public abstract class Person {
    String fullName;
    Date dOB;
    boolean isMale;
    String identityCard;
    String phoneNumber;
    String email;

    public Person(String fullName, Date dOB, boolean isMale, String identityCard, String phoneNumber, String email) {
        this.fullName = fullName;
        this.dOB = dOB;
        this.isMale = isMale;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDOB() {
        return dOB;
    }

    public void setDOB(Date dOB) {
        this.dOB = dOB;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
