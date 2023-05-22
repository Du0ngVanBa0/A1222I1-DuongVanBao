package ss17_io_binary_file_serialization.bai_tap.product_management;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String nameProduct;
    private String Manufacturers; // hãng sản xuất
    private double price;
    private String other;

    public Product() {
    }

    public Product(String id, String nameProduct, String manufacturers, double price, String other) {
        this.id = id;
        this.nameProduct = nameProduct;
        Manufacturers = manufacturers;
        this.price = price;
        this.other = other;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getManufacturers() {
        return Manufacturers;
    }

    public void setManufacturers(String manufacturers) {
        Manufacturers = manufacturers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", nameProduct=" + nameProduct + ", Manufacturers=" + Manufacturers + ", price="
                + price + ", other=" + other + "]";
    }

}