package com.springboot.health.dao;

import com.springboot.health.domain.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/10 21:44
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    User findByName(String name);


    User findByPhone(String phone);
}
