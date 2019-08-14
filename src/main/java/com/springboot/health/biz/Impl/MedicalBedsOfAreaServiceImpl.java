package com.springboot.health.biz.Impl;

import com.springboot.health.biz.MedicalBedsOfAreaService;
import com.springboot.health.dao.MedicalBedsOfAreaDao;
import com.springboot.health.domain.po.MedicalBedsOfArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/12 18:30
 */
@Service
public class MedicalBedsOfAreaServiceImpl implements MedicalBedsOfAreaService {
    @Autowired
    private MedicalBedsOfAreaDao medicalBedsOfAreaDao;
    @Override
    public List<MedicalBedsOfArea> findAll() {
        return medicalBedsOfAreaDao.findAll();
    }
}
