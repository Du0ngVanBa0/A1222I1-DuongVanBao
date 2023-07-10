package repository.product;

import model.Product;
import repository.category.CategoryRepository;

import java.util.*;

public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        CategoryRepository categoryRepository = new CategoryRepository();
        productMap.put(1, new Product(1, "Laptop Dell N1440", 2, 12000000, new Date(), categoryRepository.findByID(1)));
        productMap.put(2, new Product(2, "Laptop Asus Zenbook", 4, 13000000, new Date(), categoryRepository.findByID(1)));
        productMap.put(3, new Product(3, "Iphone 14 pro max", 3, 26000000, new Date(), categoryRepository.findByID(2)));
        productMap.put(4, new Product(4, "Samsung ZFlip", 5, 20000000, new Date(), categoryRepository.findByID(2)));
        productMap.put(5, new Product(5, "LG Oled C2 48inch", 2, 20000000, new Date(), categoryRepository.findByID(3)));
    }

    @Override
    public void add(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void delete(Product product) {
        productMap.remove(product.getId());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }
}
