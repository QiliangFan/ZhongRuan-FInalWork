package com.springboot.health.biz;

import com.springboot.health.dao.BlogImgDao;
import com.springboot.health.domain.po.BlogImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BlogImgService {
    List<BlogImg> findAll();
    BlogImg getOne(Integer id);
}
