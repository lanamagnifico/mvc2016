package com.mvc.common.service.impl;

import com.mvc.common.dao.ApplicantDao;
import com.mvc.common.model.Applicant;
import com.mvc.common.model.Position;
import com.mvc.common.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by magnifico on 23.08.17.
 */
public class ApplicantServiceImpl implements ApplicantService {
    @Autowired
    ApplicantDao applicantDao;

    @Override
    public List<Applicant> findAll() {
        return applicantDao.findAll();
    }

    @Override
    public Applicant findById(int id) {
        return applicantDao.findById(id);
    }

    @Override
    public boolean save(Applicant applicant) {
        return applicantDao.save(applicant);
    }

    @Override
    public boolean update(Applicant applicant) {
        return applicantDao.update(applicant);
    }

    @Override
    public boolean delete(Applicant applicant) {
        return applicantDao.delete(applicant);
    }

    @Override
    public List<Applicant> findByPosition(Position position) {
        return applicantDao.findByPosition(position);
    }
}
