package com.mvc.common.dao;

import com.mvc.common.model.Department;
import com.mvc.common.model.Position;
import com.mvc.common.model.Vacancy;
import java.util.List;

public interface VacancyDao {

    List<Vacancy> findAll();

    Vacancy findById(int id);

    boolean save(Vacancy vacancy);

    boolean update(Vacancy vacancy);

    boolean delete(Vacancy vacancy);

    List<Vacancy> findByPosition(Position position);

    List<Vacancy> findByDepartment(Department department);

    List<Vacancy> findOpened();
}
