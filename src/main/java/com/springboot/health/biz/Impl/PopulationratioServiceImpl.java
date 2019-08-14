package com.springboot.health.biz.Impl;

import com.springboot.health.biz.PopulationratioService;
import com.springboot.health.dao.PopulationratioDao;
import com.springboot.health.domain.po.Populationratio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PopulationratioServiceImpl implements PopulationratioService {
    @Autowired
    PopulationratioDao populationratioDao;

    @Override
    public List<Populationratio> findAll() {
        List<Populationratio> populationratios=populationratioDao.findAll();
        return populationratios;
    }
}
