package com.springboot.health.biz.Impl;

import com.springboot.health.biz.MessageService;
import com.springboot.health.dao.MessageDao;
import com.springboot.health.domain.po.History;
import com.springboot.health.domain.po.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public Message save(Message message) {
        Message returnMessage = messageDao.save(message);
        return returnMessage;
    }

    @Override
    public List<Message> findAll() {
        List<Message> list = messageDao.findAll();
        return list;
    }

    @Override
    public void delete(Message message) {
        messageDao.delete(message);
    }

    @Override
    public Message getOne(Integer id) {
        Message message = messageDao.getOne(id);
        return message;
    }

    @Override
    public Page<Message> findAllPageable(Integer page, Integer size, String sortType, String[] sortableFields) {
        Sort sort = "ASC".equals(sortType) ? new Sort(Sort.Direction.ASC, sortableFields) : new Sort(Sort.Direction.DESC, sortableFields);
        return messageDao.findAll(new PageRequest(page-1,size,sort));
    }
}
