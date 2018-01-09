package com.mvc.common.controller;

import com.mvc.common.service.LegalEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping(value = "/legalentities")
public class LegalEntityController {

    @Autowired
    LegalEntityService legalEntityService;

    @RequestMapping(value = "/all")
    public String showAll(ModelMap mpdel) {
        mpdel.addAttribute("legalentities", legalEntityService.findAll());
        return "legalentitiesmanager";
    }
}
