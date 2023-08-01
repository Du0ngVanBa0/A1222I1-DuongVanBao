package model;

import java.util.Date;

public class Customer {
    private int id;
    private CustomerType type;
    private String name;
    private Date birthday;
    private boolean gender;
    private String cardID;
    private String phone;
    private String email;
    private String address;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }

    public Customer(CustomerType type, String name, Date birthday, boolean gender, String cardID, String phone, String email, String address) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.cardID = cardID;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Customer(int id, CustomerType type, String name, Date birthday, boolean gender, String cardID, String phone, String email, String address) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.cardID = cardID;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
