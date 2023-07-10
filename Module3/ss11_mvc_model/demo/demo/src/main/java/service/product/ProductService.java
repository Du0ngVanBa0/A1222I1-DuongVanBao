package service.product;

import model.Product;
import repository.product.ProductRepository;

import java.util.List;

public class ProductService implements IProductService{
    private ProductRepository repository = new ProductRepository();
    @Override
    public void add(Product product) {
        repository.add(product);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public Product findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void update(Product product) {
        repository.update(product);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }
}
