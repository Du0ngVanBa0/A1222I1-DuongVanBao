package dvb.service;

import dvb.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void remove(int id);

    Product findByID(int id);

    void update(int id, Product product);

    void save(Product product);
}
