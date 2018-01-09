package com.mvc.common.dao;

import com.mvc.common.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class PersonDaoImpl implements PersonDao{

    @Autowired
    NamedParameterJdbcTemplate jdbc;
    private static final Logger LOGGER = Logger.getLogger(PersonDaoImpl.class.getName());

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<Person> findAll() {
        Map<String, Object> params = new HashMap<String, Object>();
        String sql = "SELECT * FROM persons ORDER BY name";
        List<Person> result = jdbc.query(sql, params, new PersonMapper());
        return result;
    }

    @Override
    public Person findById(int id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        String sql = "SELECT * FROM persons WHERE id=:id";
        Person result = jdbc.queryForObject(sql,params,new PersonMapper());
        return result;
    }

    @Override
    public boolean save(Person person) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", person.getName());
        params.put("birthday", person.getBirthDay());
        params.put("gender", person.getGender());
        String sql = "insert into persons(name,birthday,gender) values(:name,:birthday,:gender)";
        int status = jdbc.update(sql, params);
        return status == 1;
    }

    @Override
    public boolean update(Person person) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", person.getId());
        params.put("name", person.getName());
        params.put("birthday", person.getBirthDay());
        params.put("gender", person.getGender());
        String sql = "update persons set name=:name,birthday=:birthday,gender=:gender where id=:id";
        int status = jdbc.update(sql, params);
        return status == 1;
    }

    @Override
    public boolean delete(Person person) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", person.getId());
        String sql = "delete from persons where id=:id";
        int status = jdbc.update(sql, params);
        return status == 1;
    }

    private static final class PersonMapper implements RowMapper<Person> {

        public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
            Person person = new Person();
            person.setId(rs.getInt("id"));
            person.setName(rs.getString("name"));
            person.setGender(rs.getString("gender"));
            person.setBirthDay(rs.getDate("birthday"));
            return person;
        }
    }
}
