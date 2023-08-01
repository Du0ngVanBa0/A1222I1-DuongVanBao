package service.position;

import model.Position;
import repository.position.PositionRepositoryImpl;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private PositionRepositoryImpl positionRepository = new PositionRepositoryImpl();

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public Position findByID(int id) {
        return positionRepository.findByID(id);
    }
}
