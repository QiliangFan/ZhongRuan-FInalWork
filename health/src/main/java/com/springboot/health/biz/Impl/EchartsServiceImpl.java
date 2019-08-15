package com.springboot.health.biz.Impl;

import com.springboot.health.biz.ExpectedLifeService;
import com.springboot.health.dao.ExpectedLifeDao;
import com.springboot.health.domain.po.ExpectedLife;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class ExpectedLifeServiceImpl implements ExpectedLifeService {
    @Autowired
    ExpectedLifeDao expectedLifeDao;

    @Override
    public List<ExpectedLife> findAll() {
        List<ExpectedLife> expectedLives = expectedLifeDao.findAll();
        return expectedLives;
    }

    @Override
    public List<ExpectedLife> findAllByYearAndType(Integer year, String type) {
        //只要最新一年和总计
        List<ExpectedLife> expectedLifeLists = expectedLifeDao.findAllByYearAndType(year,type);
        return expectedLifeLists;
    }
}
