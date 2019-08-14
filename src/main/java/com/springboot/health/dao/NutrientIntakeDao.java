package com.springboot.health.dao;

import com.springboot.health.domain.po.NutrientIntake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyr
 * @Date
 **/
@Repository
public interface NutrientIntakeDao extends JpaRepository<NutrientIntake,Integer> {
    //按照类型（城市，乡村，合计）
    List<NutrientIntake> findByType(String type);
    List<NutrientIntake> findByYear(String year);
    List<NutrientIntake> findByNameContainingOrderByYear(String name);//按照单位查询
    List<NutrientIntake> findByNameContainingAndYearAndType(String name, String year, String type);
}
