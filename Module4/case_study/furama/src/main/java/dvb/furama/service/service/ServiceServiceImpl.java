package dvb.furama.service.service;

import dvb.furama.entity.service.Service;
import dvb.furama.repository.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public List<Service> findToCreateContract(int type1, int type2) {
        return serviceRepository.findAllServiceToContract(type1, type2);
    }
}
