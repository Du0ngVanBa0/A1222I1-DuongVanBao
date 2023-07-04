package servirce;

import model.Product;

import java.util.List;

public interface IProductService {
    void add(Product product);

    void update(Product product);

    void delete(Product product);

    Product findByID(int id);

    List<Product> findAll();
}
