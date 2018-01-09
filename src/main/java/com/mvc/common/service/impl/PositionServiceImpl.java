package com.mvc.common.service.impl;

import com.mvc.common.dao.PositionDao;
import com.mvc.common.model.Position;
import com.mvc.common.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    @Override
    public List<Position> findAll() {
        return positionDao.findAll();
    }

    @Override
    public Position findById(int id) {
        return positionDao.findById(id);
    }

    @Override
    public boolean save(Position position) {
        return positionDao.save(position);
    }

    @Override
    public boolean update(Position position) {
        return positionDao.update(position);
    }

    @Override
    public boolean delete(Position position) {
        return positionDao.delete(position);
    }
}
