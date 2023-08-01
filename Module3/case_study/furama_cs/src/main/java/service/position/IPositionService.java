package service.position;

import model.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();

    Position findByID(int id);
}
