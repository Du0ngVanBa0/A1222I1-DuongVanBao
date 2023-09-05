package dvb.book_rent.service;

import dvb.book_rent.entity.Rent;

import java.util.List;

public interface RentService {
    void create(Rent rent);

    Rent findByID(String id);

    List<Rent> findAll();

    void delete(Rent rent);
}
