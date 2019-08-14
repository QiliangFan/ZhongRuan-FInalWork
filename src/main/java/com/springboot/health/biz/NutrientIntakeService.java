package com.springboot.health.biz;

import com.springboot.health.domain.po.NutrientIntake;

import java.util.List;

/**
 * @author zyr
 * @Date
 **/
public interface NutrientIntakeService {
    //按照类型（城市，乡村，合计）
    List<NutrientIntake> findByType(String type);
    List<NutrientIntake> findByYear(String year);
    List<NutrientIntake> findByNameContaining(String name);//按照单位查询
    List<NutrientIntake> findByNameContainingAndYearAndType(String name, String year, String type);
}
