package com.springboot.health.biz;

import com.springboot.health.domain.po.ExpectedLife;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ExpectedLifeService  {
    List<ExpectedLife> findAll();

    List<ExpectedLife> findAllByYearAndType(Integer year, String type);


}
