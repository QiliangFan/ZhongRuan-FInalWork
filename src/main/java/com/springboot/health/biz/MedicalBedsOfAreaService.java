package com.springboot.health.biz;

import com.springboot.health.domain.po.MedicalBedsOfArea;

import java.util.List;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/12 17:33
 */
public interface MedicalBedsOfAreaService {
    List<MedicalBedsOfArea> findAll();
}
