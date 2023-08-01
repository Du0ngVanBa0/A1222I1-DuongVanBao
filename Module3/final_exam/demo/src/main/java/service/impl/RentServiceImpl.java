package service.impl;

import model.Rent;
import repository.impl.RentRepositoryImpl;
import service.interf.IRentService;

import java.util.List;

public class RentServiceImpl implements IRentService {
    private RentRepositoryImpl rentRepository = new RentRepositoryImpl();

    @Override
    public void add(Rent rent) {
        rentRepository.add(rent);
    }

    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }
}
