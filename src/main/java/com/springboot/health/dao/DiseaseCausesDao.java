package com.springboot.health.dao;

import com.springboot.health.domain.po.DiseaseCauses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zyr
 * @Date
 **/
@Repository
public interface DiseaseCausesDao extends JpaRepository<DiseaseCauses,Integer> {
    List<DiseaseCauses> findAllByOrderByName();
    List<DiseaseCauses> findByType(String type);
}
