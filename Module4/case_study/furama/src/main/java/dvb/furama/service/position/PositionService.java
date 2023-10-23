package dvb.furama.service.position;

import dvb.furama.entity.position.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();
}
