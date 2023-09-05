package dvb.book_rent.service;

import dvb.book_rent.entity.Rent;
import dvb.book_rent.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {
    @Autowired
    private RentRepository rentRepository;

    @Override
    public void create(Rent rent) {
        rentRepository.save(rent);
    }

    @Override
    public Rent findByID(String id) {
        return rentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    @Override
    public void delete(Rent rent) {
        rentRepository.delete(rent);
    }
}
