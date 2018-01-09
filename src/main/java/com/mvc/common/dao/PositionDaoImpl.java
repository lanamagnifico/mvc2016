package com.mvc.common.dao;

import com.mvc.common.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Repository
public class PositionDaoImpl implements PositionDao {

    @Autowired
    NamedParameterJdbcTemplate jdbc;
    private static final Logger LOGGER = Logger.getLogger(PositionDaoImpl.class.getName());

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Position> findAll() {
        Map<String, Object> params = new HashMap<String, Object>();
        String sql = "SELECT * FROM positions ORDER BY name";
        List<Position> result = jdbc.query(sql, params, new PositionMapper());
        return result;
    }

    @Override
    public Position findById(int id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        String sql = "SELECT * FROM positions WHERE id=:id";
        Position result = jdbc.queryForObject(sql, params, new PositionMapper());
        return result;
    }

    @Override
    public boolean save(Position position) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", position.getName());
        params.put("conditions", position.getConditions());
        params.put("requirements", position.getRequirements());
        String sql = "insert into positions(name,conditions,requirements) values(:name,:conditions,:requirements)";
        int status = jdbc.update(sql, params);
        return status == 1;
    }

    @Override
    public boolean update(Position position) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", position.getId());
        params.put("name", position.getName());
        params.put("conditions", position.getConditions());
        params.put("requirements", position.getRequirements());
        String sql = "update positions set name=:name,conditions=:conditions,requirements=:requirements where id=:id";
        int status = jdbc.update(sql, params);
        return status == 1;
    }

    @Override
    public boolean delete(Position position) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", position.getId());
        String sql = "delete from positions where id=:id";
        int status = jdbc.update(sql, params);
        return status == 1;
    }

    private static final class PositionMapper implements RowMapper<Position> {
        @Override
        public Position mapRow(ResultSet rs, int rowNum) throws SQLException {
            Position position = new Position();
            position.setId(rs.getInt("id"));
            position.setName(rs.getString("name"));
            position.setConditions(rs.getString("conditions"));
            position.setRequirements(rs.getString("requirements"));
            return position;
        }
    }
}
