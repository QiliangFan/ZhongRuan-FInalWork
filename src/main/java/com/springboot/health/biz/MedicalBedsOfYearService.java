package com.springboot.health.biz;

import com.springboot.health.domain.po.MedicalBedsOfYear;

import java.util.List;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/12 17:20
 */
public interface MedicalBedsOfYearService {

    List<MedicalBedsOfYear> findAll();
}
