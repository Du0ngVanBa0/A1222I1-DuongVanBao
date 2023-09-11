package dvb.cart.service;

import dvb.cart.entity.Product;

import java.util.Optional;

public interface ProductService {
    Iterable<Product> findAll();

    Optional<Product> findById(int id);
}
