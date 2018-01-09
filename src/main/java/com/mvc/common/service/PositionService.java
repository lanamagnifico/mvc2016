package com.mvc.common.service;

import com.mvc.common.model.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAll();

    Position findById(int id);

    boolean save(Position position);

    boolean update(Position position);

    boolean delete(Position position);
}
