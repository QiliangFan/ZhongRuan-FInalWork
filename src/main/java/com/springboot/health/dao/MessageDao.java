package com.springboot.health.dao;

import com.springboot.health.domain.po.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDao extends JpaRepository<Message,Integer> {
}
