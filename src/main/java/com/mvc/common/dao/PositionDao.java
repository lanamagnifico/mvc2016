package com.mvc.common.dao;

import com.mvc.common.model.Position;
import java.util.List;

public interface PositionDao {

    List<Position> findAll();

    Position findById(int id);

    boolean save(Position position);

    boolean update(Position position);

    boolean delete(Position position);
}
