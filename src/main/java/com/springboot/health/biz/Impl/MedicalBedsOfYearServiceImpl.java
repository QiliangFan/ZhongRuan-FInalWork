package com.springboot.health.biz.Impl;

import com.springboot.health.biz.MedicalBedsOfYearService;
import com.springboot.health.dao.MedicalBedsOfYearDao;
import com.springboot.health.domain.po.MedicalBedsOfYear;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/12 17:21
 */
@Service
public class MedicalBedsOfYearServiceImpl implements MedicalBedsOfYearService {

    @Autowired
    private MedicalBedsOfYearDao medicalBedsOfYearDao;
    @Override
    public List<MedicalBedsOfYear> findAll() {
        return medicalBedsOfYearDao.findAll();
    }
}
