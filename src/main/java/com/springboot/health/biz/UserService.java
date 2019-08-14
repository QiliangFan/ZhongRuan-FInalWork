package com.springboot.health.biz;

import com.springboot.health.domain.po.HealthBlog;
import com.springboot.health.domain.po.User;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/10 21:47
 */
public interface UserService {

    User findByName(String name);

    User save(User usr);

    List<User> findAll();

    User getOne(Integer id);

    User findByPhone(String phone);

    User setAuthority(User user,String authority);
    Long countAll();

    Page<User> findAllPageable(Integer page, Integer size, String sortType, String[] sortableFields);


}
