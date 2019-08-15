package com.springboot.health.biz;

import com.springboot.health.domain.po.MedicalInstitutions;

import java.util.List;

public interface MedicalInstitutionsService {

    List<MedicalInstitutions> findALl();
}
