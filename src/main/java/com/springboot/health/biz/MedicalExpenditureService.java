package com.springboot.health.biz;

import com.springboot.health.domain.po.MedicalExpenditure;

import java.util.List;

/**
 * @author zyr
 * @Date
 **/
public interface MedicalExpenditureService {
    List<MedicalExpenditure> findByTypeAndByOrderBySubtype(String type);
    List<MedicalExpenditure> findByTypeAndSubtype(String type, String subtype);
    List<MedicalExpenditure> findByType(String type);
}
