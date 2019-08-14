package com.springboot.health.dao;

import com.springboot.health.domain.po.YoungDevelopment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YoungDevelopmentDao extends JpaRepository<YoungDevelopment, Integer> {

    List<YoungDevelopment> findByAreaAndYearAndGender(String area, String year, String gender);

}
