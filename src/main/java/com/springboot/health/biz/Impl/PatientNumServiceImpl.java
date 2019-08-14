package com.springboot.health.biz.Impl;

import com.springboot.health.biz.PatientNumService;
import com.springboot.health.dao.PatientNumDao;
import com.springboot.health.domain.po.PatientNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/11 22:59
 */
@Service
public class PatientNumServiceImpl implements PatientNumService {

    @Autowired
    private PatientNumDao patientNumDao;
    @Override
    public List<PatientNum> findAll() {
        return patientNumDao.findAll();
    }
}
