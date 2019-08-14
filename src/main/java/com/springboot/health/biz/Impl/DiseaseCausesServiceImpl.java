package com.springboot.health.biz.Impl;

import com.springboot.health.biz.DiseaseCausesService;
import com.springboot.health.dao.DiseaseCausesDao;
import com.springboot.health.domain.po.DiseaseCauses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyr
 * @Date
 **/
@Service
public class DiseaseCausesServiceImpl implements DiseaseCausesService {
    @Autowired
    private DiseaseCausesDao diseaseCausesDao;

    @Override
    public List<DiseaseCauses> findAll() {
            return diseaseCausesDao.findAllByOrderByName();
    }

    @Override
    public List<DiseaseCauses> findByType(String type) {
       return diseaseCausesDao.findByType(type);
    }
}
