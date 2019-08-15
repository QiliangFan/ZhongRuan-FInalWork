package com.springboot.health.biz;

import com.springboot.health.domain.po.PatientNum;

import java.util.List;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/11 22:58
 */
public interface PatientNumService {

   List<PatientNum> findAll();
}
