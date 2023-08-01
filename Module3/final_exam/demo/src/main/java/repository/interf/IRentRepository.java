package repository.interf;

import model.Rent;

import java.util.List;

public interface IRentRepository {
    void add(Rent rent);

    List<Rent> findAll();
}
