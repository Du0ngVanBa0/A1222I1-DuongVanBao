package dvb.furama.service.rent_type;

import dvb.furama.entity.rent_type.RentType;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAll();
}
