package com.springboot.health.dao;

import com.springboot.health.domain.po.PatientNum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/11 22:57
 */
@Repository
public interface PatientNumDao extends JpaRepository<PatientNum,Integer> {

}
