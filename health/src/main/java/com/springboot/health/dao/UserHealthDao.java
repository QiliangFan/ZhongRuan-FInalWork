package com.springboot.health.dao;

import com.springboot.health.domain.po.UserHealth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserHealthDao extends JpaRepository<UserHealth,Integer> {
    List<UserHealth> findAllByUserid(Integer userid);
    List<UserHealth> findAll();
    Integer countByGender(String gender);
    Integer countByAgeBetween(Integer down,Integer up);
}
