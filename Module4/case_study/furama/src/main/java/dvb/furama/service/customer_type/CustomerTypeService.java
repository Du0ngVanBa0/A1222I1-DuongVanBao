package dvb.furama.service.customer_type;

import dvb.furama.entity.customer_type.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAll();
}
