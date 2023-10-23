package dvb.furama.repository.service;

import dvb.furama.entity.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
    @Query(nativeQuery = true ,value = "select * from service where service_type_id = :type1 or service_type_id = :type2")
    List<Service> findAllServiceToContract(@Param("type1") int type1, @Param("type2") int type2);
}
