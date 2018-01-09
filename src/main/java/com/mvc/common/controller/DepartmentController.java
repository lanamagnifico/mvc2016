package com.mvc.common.controller;

import com.mvc.common.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping(value ="/departments")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value="/all")
    public String showAll(ModelMap model){
        model.addAttribute("departments",departmentService.findAll());
        return "departmentsmanager";
    }


}
