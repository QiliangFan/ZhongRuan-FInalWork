package com.springboot.health.web.controller;


import com.springboot.health.utils.Question;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DoDataController {

    @RequestMapping("/doQuest")
    public ModelAndView doQuest(Question question){
        ModelAndView mv = new ModelAndView();
        mv.addObject("question",question);
        mv.setViewName("datashowScore");
        return mv;
    }
}
