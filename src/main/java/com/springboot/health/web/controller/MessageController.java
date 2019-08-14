package com.springboot.health.web.controller;

import com.springboot.health.biz.MessageService;
import com.springboot.health.domain.po.HealthBlog;
import com.springboot.health.domain.po.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;
    @RequestMapping("/addmessage")
    public ModelAndView addmessage(Message message){
        ModelAndView mv = new ModelAndView();
        messageService.save(message);
        mv.addObject("msg","留言成功");
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/managermessage")
    public ModelAndView managermessage(@RequestParam("currentPage") Integer currentPage){
        ModelAndView mv = new ModelAndView();

        Integer size = 5;
        String sortType = "DESC";
        String[] sortableFields = {"id"};

        if(currentPage==null || currentPage<1){
            currentPage=1;
        }

        Page<Message> page = messageService.findAllPageable(currentPage,size,sortType,sortableFields);
        if(currentPage > page.getTotalPages()){
            currentPage = page.getTotalPages();
            page = messageService.findAllPageable(currentPage,size,sortType,sortableFields);
        }

        List<Message> list = new ArrayList<>();
        page.get().forEach(x -> list.add(x));


        mv.addObject("messageslist",list);
        mv.addObject("currentPage",currentPage);
        mv.addObject("totalPage",page.getTotalPages());

        mv.setViewName("managerMessage");
        return mv;
    }
    @RequestMapping("/managermessagedelete")
    public ModelAndView managermessagedelete(Integer messageid){
        ModelAndView mv = new ModelAndView();
        Message message = messageService.getOne(messageid);
        messageService.delete(message);
        mv.addObject("currentPage",1);
        mv.setViewName("redirect:managermessage");
        return mv;
    }
}
