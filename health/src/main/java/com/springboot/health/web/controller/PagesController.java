package com.springboot.health.web.controller;

import com.springboot.health.biz.UserService;
import com.springboot.health.domain.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.expression.Lists;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/10 21:30
 */

@Controller
public class PagesController {

    @Autowired
    private UserService userService;
    @RequestMapping("/jump")
    public String jump(){

        return  "index";
    }
    @RequestMapping("/jumplogin")
    public String jumplogin(){

        return  "login";
    }
    @RequestMapping("/jump2")
    public String jump2(){
        return  "register";
    }

    @RequestMapping("/jump3")
    public String jump3(){
        return  "popu2";
    }
    @RequestMapping("/jump4")
    public String jump4(){
        return  "login";
    }



    @RequestMapping("/jump5")
    public ModelAndView jump5(@RequestParam("currentPage") Integer currentPage, HttpServletRequest request){
        List<User> list = userService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("manageuser");
        List<User> removelist = new ArrayList<>();
        for(User user:list){
            if(user.getAuthority().equals("-1")){
                removelist.add(user);
            }
        }
        if(removelist.size()>0){
            list.removeAll(removelist);
        }

        //分页 改10 改变个数
        Integer totalPages = (int) Math.ceil( list.size() / (double) 10 );

        if(currentPage == null || currentPage < 1)
        {
            currentPage = 1;
        }
        else if(currentPage > totalPages)
        {
            currentPage = totalPages;
        }

        if(list.size()>0) {
            if (currentPage != totalPages) {
                list = list.subList(10 * (currentPage - 1), 10 * currentPage);
            } else {
                list = list.subList(10 * (currentPage - 1), list.size());
            }
        }
        else {
            currentPage = 1;
            totalPages = 1;
        }

        mv.addObject("users");
        mv.addObject("users",list);
        mv.addObject("currentPage",currentPage);
        mv.addObject("totalPage",totalPages);
        return  mv;
}

//    @RequestMapping("/jump6")
//    public String jump6(){
//        return "patientnumdatashow";
//    }

    @RequestMapping("/jump7")
    public String jump7(){
        return  "loginbyphone";
    }

    @RequestMapping("/showdatapatientnum")
    public String jump8(){
        return  "datashowpatientnum";
    }

    @RequestMapping("/showdatamedicalbeds")
    public String jump9(){
        return  "datashowmedicalbeds";
    }

    @RequestMapping("/data")
    public String data(){
        return  "datashow";
    }
    @RequestMapping("/result")
    public String result(){
        return "userInfo_result";
    }

}
