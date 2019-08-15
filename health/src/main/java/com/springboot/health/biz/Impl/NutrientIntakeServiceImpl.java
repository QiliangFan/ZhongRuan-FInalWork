package com.springboot.health.biz.Impl;


import com.springboot.health.biz.NutrientIntakeService;
import com.springboot.health.dao.NutrientIntakeDao;
import com.springboot.health.domain.po.NutrientIntake;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zyr
 * @Date
 **/
@Service
public class NutrientIntakeServiceImpl implements NutrientIntakeService {
    private final NutrientIntakeDao nutrientIntakeDao;

    public NutrientIntakeServiceImpl(NutrientIntakeDao nutrientIntakeDao) {
        this.nutrientIntakeDao = nutrientIntakeDao;
    }

    @Override
    public List<NutrientIntake> findByType(String type) {
        return  nutrientIntakeDao.findByType(type);
    }

    @Override
    public List<NutrientIntake> findByYear(String year) {
        return nutrientIntakeDao.findByYear(year);
    }

    @Override
    public List<NutrientIntake> findByNameContaining(String name) {
        return nutrientIntakeDao.findByNameContainingOrderByYear(name);
    }

    @Override
    public List<NutrientIntake> findByNameContainingAndYearAndType(String name, String year,String type) {
        return nutrientIntakeDao.findByNameContainingAndYearAndType(name,year,type);
    }
}
