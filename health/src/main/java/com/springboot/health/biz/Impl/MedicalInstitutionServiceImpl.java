package com.springboot.health.biz.Impl;

import com.springboot.health.biz.MedicalInstitutionsService;
import com.springboot.health.dao.MedicalInstitutionsDao;
import com.springboot.health.domain.po.MedicalInstitutions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicalInstitutionServiceImpl implements MedicalInstitutionsService {
    @Autowired
    MedicalInstitutionsDao medicalInstitutionsDao;

    @Override
    public List<MedicalInstitutions> findALl() {
        List<MedicalInstitutions> medicalInstitutions = medicalInstitutionsDao.findAll();
        return medicalInstitutions;
    }
}
