package dvb.demo.repository;

import dvb.demo.entity.Product;
import dvb.demo.entity.ProductType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Page<Product> findAllByNameContainingOrPriceOrProductType(String name, int price, ProductType productType, Pageable pageable);
}
