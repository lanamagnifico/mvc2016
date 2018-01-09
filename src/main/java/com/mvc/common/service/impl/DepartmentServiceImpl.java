package com.mvc.common.service.impl;

import com.mvc.common.dao.DepartmentDao;
import com.mvc.common.model.Department;
import com.mvc.common.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentDao departmentDao;
    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }
}
