package service.interf;

import model.Rent;

import java.util.List;

public interface IRentService {
    void add(Rent rent);

    List<Rent> findAll();
}
