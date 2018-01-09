package com.mvc.common.service;

import com.mvc.common.model.Applicant;
import com.mvc.common.model.Position;
import java.util.List;

public interface ApplicantService {
    List<Applicant> findAll();

    Applicant findById(int id);

    boolean save(Applicant applicant);

    boolean update(Applicant applicant);

    boolean delete(Applicant applicant);

    List<Applicant> findByPosition(Position position);
}
