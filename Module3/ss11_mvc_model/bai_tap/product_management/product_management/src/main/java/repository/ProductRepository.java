package repository;

import model.Product;

import java.util.*;

public class ProductRepository implements IProductRepository {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "Bao", 5, 12000, new Date()));
        productMap.put(2, new Product(2, "Bao", 5, 12000, new Date()));
        productMap.put(3, new Product(3, "Bao", 5, 12000, new Date()));
        productMap.put(4, new Product(4, "Bao", 5, 12000, new Date()));
        productMap.put(5, new Product(5, "Bao", 5, 12000, new Date()));
    }

    @Override
    public void add(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void delete(Product product) {
        productMap.remove(product.getId());
    }

    @Override
    public Product findByID(int id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }
}
