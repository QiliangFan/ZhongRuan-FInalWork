package com.springboot.health.biz.Impl;

import com.springboot.health.biz.HealthBlogService;
import com.springboot.health.dao.HealthBlogDao;
import com.springboot.health.domain.po.HealthBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthBlogServiceImpl implements HealthBlogService {
    @Autowired
    private HealthBlogDao healthBlogDao;
    @Override
    public HealthBlog save(HealthBlog healthBlog) {
        HealthBlog returnHealthBlog = healthBlogDao.save(healthBlog);
        return returnHealthBlog;
    }

    @Override
    public List<HealthBlog> findAll() {
        List<HealthBlog>list = healthBlogDao.findAll();
        return list;
    }

    @Override
    public HealthBlog getOne(Integer id) {
         HealthBlog healthBlog =healthBlogDao.getOne(id);
        return healthBlog;
    }

    @Override
    public Page<HealthBlog> findAllPageable(Integer page, Integer size, String sortType, String[] sortableFields) {
        Sort sort = "ASC".equals(sortType) ? new Sort(Sort.Direction.ASC, sortableFields) : new Sort(Sort.Direction.DESC, sortableFields);
        return healthBlogDao.findAll(new PageRequest(page-1,size,sort));
    }

    @Override
    public void delete(HealthBlog healthBlog) {
        healthBlogDao.delete(healthBlog);
    }
    @Override
    public Long countAll() {
        return healthBlogDao.count();
    }
}
