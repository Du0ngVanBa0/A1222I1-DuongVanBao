package case_study.FuramaResort.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer extends Person {
    private String customerCode;
    private String typeCustomer;
    private String address;

    public Customer(String fullName, Date dOB, boolean isMale, String identityCard, String phoneNumber, String email, String customerCode, String typeCustomer, String address) {
        super(fullName, dOB, isMale, identityCard, phoneNumber, email);
        this.customerCode = customerCode;
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Customer{" +
                "customerCode='" + customerCode + '\'' +
                ", typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                ", fullName='" + fullName + '\'' +
                ", dOB=" + simpleDateFormat.format(dOB) +
                ", isMale=" + isMale +
                ", identityCard='" + identityCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }
}