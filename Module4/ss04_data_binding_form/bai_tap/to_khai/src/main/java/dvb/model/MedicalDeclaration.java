package dvb.model;

import java.util.Date;
import java.util.List;

public class MedicalDeclaration {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBornYear() {
        return bornYear;
    }

    public void setBornYear(int bornYear) {
        this.bornYear = bornYear;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public String getTransportCode() {
        return transportCode;
    }

    public void setTransportCode(String transportCode) {
        this.transportCode = transportCode;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public String getCamePlace() {
        return camePlace;
    }

    public void setCamePlace(String camePlace) {
        this.camePlace = camePlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Disease> getDiseases() {
        return diseases;
    }

    public void setDiseases(List<Disease> diseases) {
        this.diseases = diseases;
    }

    public MedicalDeclaration(String id, String name, int bornYear, boolean gender, String nationality, String identityCard, String transport, String transportCode, int seats, Date dateStart, String camePlace, String address, String phone, String email, List<Disease> diseases) {
        this.id = id;
        this.name = name;
        this.bornYear = bornYear;
        this.gender = gender;
        this.nationality = nationality;
        this.identityCard = identityCard;
        this.transport = transport;
        this.transportCode = transportCode;
        this.seats = seats;
        this.dateStart = dateStart;
        this.camePlace = camePlace;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.diseases = diseases;
    }

    public MedicalDeclaration() {
    }

    private String name;
    private int bornYear;
    private boolean gender;
    private String nationality;
    private String identityCard;
    private String transport;
    private String transportCode;
    private int seats;
    private Date dateStart;
    private String camePlace;
    private String address;
    private String phone;
    private String email;
    private List<Disease> diseases;
}
