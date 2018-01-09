package com.mvc.common.dao;

import com.mvc.common.model.LegalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LegalEntityDao extends JpaRepository<LegalEntity,Long> {
    @Query("select l from LegalEntity l where l.inn = :inn")
    List<LegalEntity> findByInn(@Param("inn") String inn);
}
