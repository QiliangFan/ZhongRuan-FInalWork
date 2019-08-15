package com.springboot.health.dao;

import com.springboot.health.domain.po.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoryDao extends JpaRepository<History,Integer> {
    List<History> findByUserid(Integer id);
}
