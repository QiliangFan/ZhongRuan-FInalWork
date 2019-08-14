package com.springboot.health.biz;

import com.springboot.health.domain.po.HealthBlog;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HealthBlogService {
    HealthBlog save(HealthBlog healthBlog);
    List<HealthBlog> findAll();
    HealthBlog getOne(Integer id);
    Page<HealthBlog> findAllPageable(Integer page, Integer size, String sortType, String[] sortableFields);
    void delete(HealthBlog healthBlog);
    Long countAll();
}
