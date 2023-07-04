package model;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private long price;
    private Date dateRelease;

    public Product(int id, String name, int quantity, long price, Date dateRelease) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.dateRelease = dateRelease;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }
}
