package com.springboot.health.biz;

import com.springboot.health.domain.po.HealthBlog;
import com.springboot.health.domain.po.History;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HistoryService {
    History save(History history);
    void delete(History history);
    List<History> findAll();
    History getOne(Integer id);
    Long countAll();
    Page<History> findAllPageable(Integer page, Integer size, String sortType, String[] sortableFields);

}
