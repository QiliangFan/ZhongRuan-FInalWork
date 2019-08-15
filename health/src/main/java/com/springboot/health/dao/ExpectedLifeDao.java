package com.springboot.health.dao;

import com.springboot.health.domain.po.ExpectedLife;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpectedLifeDao extends JpaRepository<ExpectedLife,Integer> {
    List<ExpectedLife> findAllByYearAndType(Integer year, String type);
}
