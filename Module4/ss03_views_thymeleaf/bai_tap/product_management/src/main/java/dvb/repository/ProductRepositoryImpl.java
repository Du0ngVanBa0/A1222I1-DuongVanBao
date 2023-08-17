package dvb.repository;

import dvb.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static Map<Integer, Product> productMap;

    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "lan nach", 500, "tri dau dau hieu qua", "thai duong"));
        productMap.put(2, new Product(2, "quat tran", 1200, "quat rat mat", "shinji"));
        productMap.put(3, new Product(3, "ao", 530, "ao trang dep", "adu pro"));
        productMap.put(4, new Product(4, "ban phim", 2300, "layout 68", "dareu"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findByID(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Product product : productMap.values()) {
            if (product.getName().contains(name)) {
                searchList.add(product);
            }
        }
        return searchList;
    }
}
