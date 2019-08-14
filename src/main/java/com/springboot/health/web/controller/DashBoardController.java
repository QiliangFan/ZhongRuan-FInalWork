package com.springboot.health.web.controller;

import com.springboot.health.biz.HealthBlogService;
import com.springboot.health.biz.HistoryService;
import com.springboot.health.biz.UserHealthService;
import com.springboot.health.biz.UserService;
import com.springboot.health.domain.po.Static;
import com.springboot.health.domain.po.UserHealth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zyr
 * @Date
 **/
@Controller
public class DashBoardController {
    @Autowired
    private UserHealthService userHealthService;
    @Autowired
    private UserService userService;
    @Autowired
    private HealthBlogService healthBlogService;
    @Autowired
    private HistoryService historyService;
    @RequestMapping("/getUserHealth")
    @ResponseBody
    public List<UserHealth> getUserHealth()
    {
       return userHealthService.findAll();
    }
    @RequestMapping("/getUserGender")
    @ResponseBody
    public List<Static> getUserGender()
    {
       Integer num1=userHealthService.countByGender("女");
       Integer num2=userHealthService.countByGender("男");
       Static static1=new Static("女",num1);
       Static static2=new Static ("男",num2);
       List<Static> statics=new ArrayList<Static>();
       statics.add(static1);
       statics.add(static2);
       return statics;
    }
    @RequestMapping("/getUserAge")
    @ResponseBody
    public List<Static> getUserAge()
    {
        Integer num1=userHealthService.countByAgeBetween(0,10);
        Integer num2=userHealthService.countByAgeBetween(10,20);
        Integer num3=userHealthService.countByAgeBetween(20,30);
        Integer num4=userHealthService.countByAgeBetween(30,40);
        Integer num5=userHealthService.countByAgeBetween(40,50);
        Integer num6=userHealthService.countByAgeBetween(50,60);
        Integer num7=userHealthService.countByAgeBetween(60,200);
        Static static1=new Static("10岁以下",num1);
        Static static2=new Static ("10-20岁",num2);
        Static static3=new Static ("20-30岁",num3);
        Static static4=new Static ("30-40岁",num4);
        Static static5=new Static ("40-50岁",num5);
        Static static6=new Static ("50-60岁",num6);
        Static static7=new Static ("60岁以上",num7);
        List<Static> statics=new ArrayList<Static>();
        statics.add(static1);
        statics.add(static2);
        statics.add(static3);
        statics.add(static4);
        statics.add(static5);
        statics.add(static6);
        statics.add(static7);
        return statics;
    }

@RequestMapping("toDashBoard")
    public ModelAndView toDashBoard()
{
    ModelAndView mv=new ModelAndView();
    Long userNum=userService.countAll();
   Long blogNum=healthBlogService.countAll();
    Long historyNum=historyService.countAll();
    Long userHealthNum=userHealthService.countAll();
    mv.addObject("userNum",userNum);
    mv.addObject("blogNum",blogNum);
    mv.addObject("historyNum",historyNum);
    mv.addObject("userHealthNum",userHealthNum);
    mv.setViewName("dashboard");
    return mv;

}

}
