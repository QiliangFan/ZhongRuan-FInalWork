package com.springboot.health.dao;

import com.springboot.health.domain.po.MedicalExpenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyr
 * @Date
 **/
@Repository
public interface MedicalExpenditureDao extends JpaRepository<MedicalExpenditure,Integer> {
    List<MedicalExpenditure> findByTypeOrderBySubtype(String type);
    List<MedicalExpenditure> findByTypeAndSubtype(String type, String subtype);
    List<MedicalExpenditure> findByType(String type);
}
