package entities;

public class Customer {
    private String name;
    private String dOB;
    private String address;
    private String urlImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getdOB() {
        return dOB;
    }

    public void setdOB(String dOB) {
        this.dOB = dOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Customer(String name, String dOB, String address, String urlImage) {
        this.name = name;
        this.dOB = dOB;
        this.address = address;
        this.urlImage = urlImage;
    }
}
