package com.mvc.common.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.mvc.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    NamedParameterJdbcTemplate jdbc;
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class.getName());


    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbc = namedParameterJdbcTemplate;
    }

    @Override
    public User findByName(String name) {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        String sql = "SELECT * FROM users WHERE name LIKE :name";
        User result = jdbc.queryForObject(
                sql,
                params,
                new UserMapper());
        return result;

    }

    @Override
    public List<User> findAll() {
        Map<String, Object> params = new HashMap<String, Object>();
        String sql = "SELECT * FROM users";
        List<User> result = jdbc.query(sql, params, new UserMapper());
        return result;
    }

    @Override
    public boolean save(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name",user.getName());
        params.put("email",user.getEmail());
        params.put("imageSrc",user.getImageSrc());
        params.put("password",user.getPassword());
        String sql = "insert into users(name,password,email,imageSrc) values(:name,:password,:email,:imageSrc)";
        int status = jdbc.update(sql, params);
        return status == 1;
    }

    @Override
    public boolean update(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name",user.getName());
        params.put("email",user.getEmail());
        params.put("imageSrc",user.getImageSrc());
        params.put("id",user.getId());
        String sql = "update users set name=:name,email=:email,imageSrc=:imageSrc where id=:id";
        return false;
    }

    private static final class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setEmail(rs.getString("email"));
            user.setImageSrc(rs.getString("imageSrc"));
            return user;
        }
    }
}
