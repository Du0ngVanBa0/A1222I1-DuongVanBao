package dvb.repository;

import dvb.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void remove(int id);

    Product findByID(int id);

    void update(int id, Product product);

    void save(Product product);

    List<Product> findByName(String name);
}
