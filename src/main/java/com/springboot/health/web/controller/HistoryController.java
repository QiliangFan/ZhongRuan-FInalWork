package com.springboot.health.web.controller;

import com.springboot.health.biz.HistoryService;
import com.springboot.health.domain.po.HealthBlog;
import com.springboot.health.domain.po.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HistoryController {
    @Autowired
    private HistoryService historyService;
    @RequestMapping("/addhistory")
    public ModelAndView addhistory(History history){
        ModelAndView mv = new ModelAndView();
        historyService.save(history);
        return mv;
    }

    ///
    @RequestMapping("/managerhistory")
    public ModelAndView managerhistory(@RequestParam("currentPage") Integer currentPage){
        ModelAndView mv = new ModelAndView();

        Integer size = 5;
        String sortType = "DESC";
        String[] sortableFields = {"time"};

        if(currentPage==null || currentPage<1){
            currentPage=1;
        }

        Page<History> page = historyService.findAllPageable(currentPage,size,sortType,sortableFields);

        if(currentPage > page.getTotalPages()){
            currentPage = page.getTotalPages();
            page = historyService.findAllPageable(currentPage,size,sortType,sortableFields);
        }

        List<History> list = new ArrayList<>();
        page.get().forEach(x -> list.add(x));


        mv.addObject("historylist",list);
        mv.addObject("currentPage",currentPage);
        mv.addObject("totalPage",page.getTotalPages());


        mv.addObject("managerHistory");
        return mv;
    }



    @RequestMapping("/managerdeletehistory")
    public ModelAndView managerdeletehistory(Integer historyid){
        ModelAndView mv = new ModelAndView();
        History history = historyService.getOne(historyid);
        historyService.delete(history);
        mv.addObject("currentPage",1);
        mv.setViewName("redirect:managerhistory");
        return mv;
    }
}
