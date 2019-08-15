package com.springboot.health.dao;

import com.springboot.health.domain.po.MedicalBedsOfArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/12 17:32
 */
@Repository
public interface MedicalBedsOfAreaDao extends JpaRepository<MedicalBedsOfArea,Integer> {
}
