package com.springboot.health.biz.Impl;

import com.springboot.health.biz.BlogImgService;
import com.springboot.health.dao.BlogImgDao;
import com.springboot.health.domain.po.BlogImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogImgServiceImpl implements BlogImgService {
    @Autowired
    private BlogImgDao blogImgDao;

    @Override
    public List<BlogImg> findAll() {
        List<BlogImg> list = blogImgDao.findAll();
        return list;
    }

    @Override
    public BlogImg getOne(Integer id) {
        BlogImg blogImg = blogImgDao.getOne(id);
        return blogImg;
    }
}
