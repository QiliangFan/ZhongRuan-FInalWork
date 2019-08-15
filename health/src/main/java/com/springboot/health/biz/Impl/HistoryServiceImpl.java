package com.springboot.health.biz.Impl;

import com.springboot.health.biz.HistoryService;
import com.springboot.health.dao.HistoryDao;
import com.springboot.health.domain.po.HealthBlog;
import com.springboot.health.domain.po.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDao historyDao;
    @Override
    public History save(History history) {
        History returnhistory = historyDao.save(history);
        return returnhistory;
    }

    @Override
    public void delete(History history) {
        historyDao.delete(history);
    }

    @Override
    public List<History> findAll() {
        List<History> list = historyDao.findAll();
        return list;
    }

    @Override
    public History getOne(Integer id) {
        History history = historyDao.getOne(id);
        return history;
    }
    @Override
    public Long countAll() {
        return historyDao.count();
    }

    @Override
    public Page<History> findAllPageable(Integer page, Integer size, String sortType, String[] sortableFields) {
        Sort sort = "ASC".equals(sortType) ? new Sort(Sort.Direction.ASC, sortableFields) : new Sort(Sort.Direction.DESC, sortableFields);
        return historyDao.findAll(new PageRequest(page-1,size,sort));
    }
}
