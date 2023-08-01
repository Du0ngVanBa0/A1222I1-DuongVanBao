package service.division;

import model.Division;
import repository.division.DivisionRepositoryImpl;

import java.util.List;

public class DivisionServiceImpl implements IDivisionService {
    private DivisionRepositoryImpl divisionRepository = new DivisionRepositoryImpl();

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Division findByID(int id) {
        return divisionRepository.findByID(id);
    }
}
