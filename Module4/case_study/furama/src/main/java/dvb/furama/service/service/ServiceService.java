package dvb.furama.service.service;

import dvb.furama.entity.service.Service;

import java.util.List;

public interface ServiceService {
    void save(Service service);

    List<Service> findAll();

    List<Service> findToCreateContract(int type1, int type2);
}
