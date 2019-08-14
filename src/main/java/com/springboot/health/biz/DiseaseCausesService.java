package com.springboot.health.biz;

import com.springboot.health.domain.po.DiseaseCauses;

import java.util.List;

/**
 * @author zyr
 * @Date
 **/
public interface DiseaseCausesService {
    List<DiseaseCauses> findAll();
    List<DiseaseCauses> findByType(String type);
}
