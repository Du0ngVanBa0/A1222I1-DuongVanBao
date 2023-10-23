package dvb.demo.service;

import dvb.demo.entity.ProductType;

import java.util.List;
import java.util.Optional;

public interface ProductTypeService {
    List<ProductType> findAll();

    Optional<ProductType> findById(int id);
}
