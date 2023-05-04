package FuramaResort.models;

public abstract class Person {
    String fullName;
    String dOB;
    boolean isMale;
    String identityCard;
    String phoneNumber;
    String email;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
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

    public Person(String fullName, String dOB, boolean isMale, String identityCard, String phoneNumber, String email) {
        this.fullName = fullName;
        this.dOB = dOB;
        this.isMale = isMale;
        this.identityCard = identityCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
