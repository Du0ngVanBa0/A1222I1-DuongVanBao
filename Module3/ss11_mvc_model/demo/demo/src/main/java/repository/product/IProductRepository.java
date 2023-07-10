package repository.product;

import model.Product;

import java.util.List;

public interface IProductRepository {
    void add(Product product);

    void delete(Product product);

    Product findById(int id);

    void update(Product product);

    List<Product> findAll();
}
