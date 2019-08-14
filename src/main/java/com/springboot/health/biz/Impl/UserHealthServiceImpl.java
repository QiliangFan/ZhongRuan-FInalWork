package com.springboot.health.biz.Impl;

import com.springboot.health.biz.UserHealthService;
import com.springboot.health.dao.UserHealthDao;
import com.springboot.health.domain.po.UserHealth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserHealthServiceImpl implements UserHealthService {
    @Autowired
    private UserHealthDao userHealthDao;

    @Override
    public List<UserHealth> findAllByUserid(Integer userid) {
        List<UserHealth> list = userHealthDao.findAllByUserid(userid);
        return list;
    }
    @Override
    public List<UserHealth> findAll() {
        return userHealthDao.findAll();
    }

    @Override
    public Integer countByGender(String gender) {
        return userHealthDao.countByGender(gender);
    }

    @Override
    public Integer countByAgeBetween(Integer down, Integer up) {
        return userHealthDao.countByAgeBetween(down,up);
    }

    @Override
    public Long countAll() {
        return userHealthDao.count();
    }
}
