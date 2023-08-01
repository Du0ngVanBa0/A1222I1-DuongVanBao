package repository.division;

import model.Division;

import java.util.List;

public interface IDivisionRepository {
    List<Division> findAll();
    Division findByID(int id);
}
