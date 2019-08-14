package com.springboot.health.biz.Impl;

import com.springboot.health.biz.YoungDevelopmentService;
import com.springboot.health.dao.YoungDevelopmentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class YoungDevelopmentServiceImpl implements YoungDevelopmentService {
    @Autowired
    private YoungDevelopmentDao youngDevelopmentDao;

    @Override
    public List<Float> getHeightData(String area, String year, String gender) {
        List<Float> list = new ArrayList<>();
        youngDevelopmentDao.findByAreaAndYearAndGender(area, year, gender).forEach(x -> list.add(x.getAvgHeight()));
        return list;
    }

    @Override
    public List<Float> getWeightData(String area, String year, String gender) {
        List<Float> list = new ArrayList<>();
        youngDevelopmentDao.findByAreaAndYearAndGender(area, year, gender).forEach(x -> list.add(x.getAvgWeight()));
        return list;}
}
