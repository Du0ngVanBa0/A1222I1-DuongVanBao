package dvb.furama.repository.customer_type;

import dvb.furama.entity.customer_type.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
