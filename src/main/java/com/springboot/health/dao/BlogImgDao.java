package com.springboot.health.dao;

import com.springboot.health.domain.po.BlogImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogImgDao extends JpaRepository<BlogImg,Integer> {
}
