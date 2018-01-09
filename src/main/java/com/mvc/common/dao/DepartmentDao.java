package com.mvc.common.dao;

import com.mvc.common.model.Department;
import java.util.List;

import com.mvc.common.model.LegalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DepartmentDao extends JpaRepository<Department,Long>{
    @Query("select d from Department d where d.legalEntity = :legalEntity")
    List<Department> findByEntity(@Param("legalEntity") LegalEntity legalEntity);
}
