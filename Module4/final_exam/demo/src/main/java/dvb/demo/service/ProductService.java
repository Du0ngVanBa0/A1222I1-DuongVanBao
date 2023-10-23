package dvb.demo.service;

import dvb.demo.entity.Product;
import dvb.demo.entity.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {
    Page<Product> findAllPaging(Pageable pageable);

    void save(Product product);

    Optional<Product> findById(int id);

    void deleteById(int id);

    Page<Product> search(String name, int price, ProductType productType, Pageable pageable);
}
