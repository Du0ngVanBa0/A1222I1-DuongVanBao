package dvb.phone_management.entity;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class SmartphoneDto {
    private int id;

    @NotEmpty
    private String producer;

    @NotEmpty
    private String model;

    @DecimalMin(value = "0")
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SmartphoneDto(String producer, String model, double price) {
        this.producer = producer;
        this.model = model;
        this.price = price;
    }
}
