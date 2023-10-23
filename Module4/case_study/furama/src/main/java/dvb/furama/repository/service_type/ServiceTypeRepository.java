package dvb.furama.repository.service_type;

import dvb.furama.entity.service_type.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}
