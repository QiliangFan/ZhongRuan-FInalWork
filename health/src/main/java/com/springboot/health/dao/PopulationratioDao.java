package com.springboot.health.dao;

import com.springboot.health.domain.po.Populationratio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PopulationratioDao extends JpaRepository<Populationratio,Integer> {

}
