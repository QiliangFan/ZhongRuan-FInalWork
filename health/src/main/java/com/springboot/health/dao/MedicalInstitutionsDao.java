package com.springboot.health.dao;

import com.springboot.health.domain.po.MedicalInstitutions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalInstitutionsDao extends JpaRepository<MedicalInstitutions,Integer> {


}
