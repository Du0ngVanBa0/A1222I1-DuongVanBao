package dvb.furama.service.service_type;

import dvb.furama.entity.service_type.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAll();
}
