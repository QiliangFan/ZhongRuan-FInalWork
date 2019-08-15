package com.springboot.health.biz.Impl;

import com.springboot.health.biz.UserService;
import com.springboot.health.dao.UserDao;
import com.springboot.health.domain.po.History;
import com.springboot.health.domain.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/10 21:47
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }

    @Override
    public User save(User usr) {
        return userDao.save(usr);
    }

    @Override
    public List<User> findAll() {
        List<User> list = userDao.findAll();
        return list;
    }

    @Override
    public User getOne(Integer id) {
        User user = userDao.getOne(id);
        return user;
    }

    @Override
    public User setAuthority(User user, String authority) {
        user.setAuthority(authority);
        return userDao.save(user);
    }


    @Override
    public User findByPhone(String phone) {
        return userDao.findByPhone(phone);
    }
    @Override
    public Long countAll() {
        return userDao.count();
    }

    @Override
    public Page<User> findAllPageable(Integer page, Integer size, String sortType, String[] sortableFields) {
        Sort sort = "ASC".equals(sortType) ? new Sort(Sort.Direction.ASC, sortableFields) : new Sort(Sort.Direction.DESC, sortableFields);
        return userDao.findAll(new PageRequest(page-1,size,sort));
    }
}
