package dvb.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private int id;

    @Size(min = 5, max = 50, message = "Tên sản phẩm phải là 5 đến 50 ký tự!")
    private String name;

    @Min(value = 100000, message = "Giá bắt đầu phải là số và thấp nhất phải là 100.000 VND")
    private int price;

    private String status;

    @ManyToOne
    @JoinColumn(name = "product_type_id", referencedColumnName = "id")
    private ProductType productType;

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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Product() {
    }

    public Product(String name, int price, String status, ProductType productType) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.productType = productType;
    }

    public Product(int id, String name, int price, String status, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.productType = productType;
    }
}
