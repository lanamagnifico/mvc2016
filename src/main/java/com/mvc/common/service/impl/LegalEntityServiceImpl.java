package com.mvc.common.service.impl;

import com.mvc.common.dao.LegalEntityDao;
import com.mvc.common.model.LegalEntity;
import com.mvc.common.service.LegalEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LegalEntityServiceImpl implements LegalEntityService {

    @Autowired
    LegalEntityDao legalEntityDao;
    @Override
    public List<LegalEntity> findAll() {
        return legalEntityDao.findAll();
    }
}
