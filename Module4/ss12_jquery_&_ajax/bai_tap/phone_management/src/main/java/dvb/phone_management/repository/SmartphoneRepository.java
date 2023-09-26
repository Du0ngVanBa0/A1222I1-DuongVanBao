package dvb.phone_management.repository;

import dvb.phone_management.entity.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Integer> {
}
