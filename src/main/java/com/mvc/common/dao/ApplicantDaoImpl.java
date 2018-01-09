package com.mvc.common.dao;


import com.mvc.common.model.Applicant;
import com.mvc.common.model.Position;
import com.mvc.common.service.ApplicantService;
import com.mvc.common.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ApplicantDaoImpl implements ApplicantDao {

    @Autowired
    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    private PositionDao positionDao;

    @Override
    public List<Applicant> findAll() {
        Map<String, Object> params = new HashMap<String, Object>();
        String sql = "SELECT * FROM applicants ORDER BY name";
        List<Applicant> result = jdbc.query(sql, params, new ApplicantMapper());
        return result;
    }

    @Override
    public Applicant findById(int id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        String sql = "SELECT * FROM applicants WHERE id=:id";
        Applicant result = jdbc.queryForObject(sql, params, new ApplicantMapper());
        return result;
    }

    @Override
    public boolean save(Applicant applicant) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", applicant.getName());
        params.put("positionId", applicant.getPosition().getId());
        String sql = "insert into applicants(name,positionId) values(:name,:positionId)";
        int status = jdbc.update(sql, params);
        return status==1;
    }

    @Override
    public boolean update(Applicant applicant) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", applicant.getId());
        params.put("name", applicant.getName());
        params.put("positionId", applicant.getPosition().getId());
        String sql = "update applicants set name=:name,positionId=:positionId where id=:id";
        int status = jdbc.update(sql, params);
        return status == 1;
    }

    @Override
    public boolean delete(Applicant applicant) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", applicant.getId());
        String sql = "delete from applicants where id=:id";
        int status = jdbc.update(sql, params);
        return status == 1;
    }

    @Override
    public List<Applicant> findByPosition(Position position) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("positionId", position.getId());
        String sql = "SELECT * FROM applicants WHERE positionId=:positionId ORDER BY name";
        List<Applicant> result = jdbc.query(sql, params, new ApplicantMapper());
        return result;
    }

    private static final class ApplicantMapper implements RowMapper<Applicant> {

        @Override
        public Applicant mapRow(ResultSet rs, int rowNum) throws SQLException {
            Applicant applicant = new Applicant();
            applicant.setId(rs.getInt("id"));
            applicant.setName(rs.getString("name"));
            applicant.setPosition(new PositionDaoImpl().findById(rs.getInt("positionId")));
            return applicant;
        }
    }
}
