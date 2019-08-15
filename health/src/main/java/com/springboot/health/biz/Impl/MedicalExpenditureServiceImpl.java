package com.springboot.health.biz.Impl;

import com.springboot.health.biz.MedicalExpenditureService;
import com.springboot.health.dao.MedicalExpenditureDao;
import com.springboot.health.domain.po.MedicalExpenditure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyr
 * @Date
 **/
@Service
public class MedicalExpenditureServiceImpl implements MedicalExpenditureService {

@Autowired
private MedicalExpenditureDao medicalExpenditureDao;
    @Override
    public List<MedicalExpenditure> findByTypeAndByOrderBySubtype(String type) {
        return medicalExpenditureDao.findByTypeOrderBySubtype(type);
    }

    @Override
    public List<MedicalExpenditure> findByTypeAndSubtype(String type, String subtype) {
        return medicalExpenditureDao.findByTypeAndSubtype(type,subtype);
    }

    @Override
    public List<MedicalExpenditure> findByType(String type) {
        return medicalExpenditureDao.findByType(type);
    }


}
