package com.springboot.health.biz;

import com.springboot.health.domain.po.HealthBlog;
import com.springboot.health.domain.po.Message;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MessageService {
    Message save(Message message);
    List<Message> findAll();
    void delete(Message message);
    Page<Message> findAllPageable(Integer page, Integer size, String sortType, String[] sortableFields);
    Message getOne(Integer id);
}
