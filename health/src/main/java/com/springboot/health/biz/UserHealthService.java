package com.springboot.health.biz;

import com.springboot.health.domain.po.UserHealth;

import java.util.List;

public interface UserHealthService {
    List<UserHealth> findAllByUserid(Integer userid);
    List<UserHealth> findAll();
    Integer countByGender(String gender);
    Integer countByAgeBetween(Integer down,Integer up);
    Long countAll();
}
