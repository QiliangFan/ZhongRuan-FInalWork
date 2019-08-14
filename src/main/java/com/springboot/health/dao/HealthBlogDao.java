package com.springboot.health.dao;

import com.springboot.health.domain.po.HealthBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthBlogDao extends JpaRepository<HealthBlog,Integer> {

}
