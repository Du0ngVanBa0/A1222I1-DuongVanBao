package dvb.phone_management.service;

import dvb.phone_management.entity.Smartphone;

import java.util.Optional;

public interface SmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(int id);

    Smartphone save(Smartphone smartphone);

    void remove(int id);
}
