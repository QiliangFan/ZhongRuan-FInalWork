package com.springboot.health.web.controller;

import com.springboot.health.biz.BlogImgService;
import com.springboot.health.biz.HealthBlogService;
import com.springboot.health.biz.HistoryService;
import com.springboot.health.biz.UserService;
import com.springboot.health.domain.po.BlogImg;
import com.springboot.health.domain.po.HealthBlog;
import com.springboot.health.domain.po.History;
import com.springboot.health.domain.po.User;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HealthBlogController {
    @Autowired
    private HealthBlogService healthBlogService;
    @Autowired
    private BlogImgService blogImgService;
    @Autowired
    private UserService userService;
    @Autowired
    private HistoryService historyService;
    @RequestMapping("/addblog")
    public ModelAndView addlog(Model model,HealthBlog healthBlog,Integer userId){
        ModelAndView mv = new ModelAndView();
        List<BlogImg> list = blogImgService.findAll();
        Random random = new Random();
        int randomNum = random.nextInt((list.size()-1 - 0) + 1);
        HealthBlog healthBlog1 = healthBlog;
        healthBlog1.setBadNum(0);
        healthBlog1.setGoodNum(0);
        healthBlog1.setNumOfPeople(0);
        healthBlog1.setUserId(userId);
        healthBlog1.setImgId(randomNum);
//        healthBlog1.setImgId(1);
        healthBlog1.setTime(new Date(System.currentTimeMillis()));
        HealthBlog healthBlog2 = healthBlogService.save(healthBlog1);
        if(healthBlog2.getId()!=null){
            History history = new History("发表 Health Blog",healthBlog1.getTitle(),userId,""+new Timestamp(System.currentTimeMillis()));
            historyService.save(history);
            mv.addObject("msg","发表成功");
        }else{
            mv.addObject("msg","发表失败");
        }
        mv.addObject("currentPage",1);
        mv.setViewName("redirect:getAllBlog");
        return mv;
    }
    @RequestMapping("/goodscore")
    public ModelAndView goodscore(Integer userId,String blogId){
        ModelAndView mv = new ModelAndView();
        HealthBlog healthBlog = healthBlogService.getOne(Integer.valueOf(blogId));
        healthBlog.setGoodNum(healthBlog.getGoodNum()+1);
        healthBlog.setNumOfPeople(healthBlog.getNumOfPeople()+1);
        healthBlogService.save(healthBlog);

        History history = new History("点赞",healthBlog.getTitle(),userId,""+new Timestamp(System.currentTimeMillis()));
        historyService.save(history);

        mv.addObject("currentPage",1);
        mv.setViewName("redirect:getAllBlog");
        return mv;
    }
    @RequestMapping("/badscore")
    public ModelAndView badscore(Integer userId,String blogId){
        ModelAndView mv = new ModelAndView();
        HealthBlog healthBlog = healthBlogService.getOne(Integer.valueOf(blogId));
        healthBlog.setBadNum(healthBlog.getBadNum()+1);
        healthBlog.setNumOfPeople(healthBlog.getNumOfPeople()+1);
        healthBlogService.save(healthBlog);

        History history = new History("踩踩踩",healthBlog.getTitle(),userId,""+new Timestamp(System.currentTimeMillis()));
        historyService.save(history);

        mv.addObject("currentPage",1);
        mv.setViewName("redirect:getAllBlog");
        return mv;
    }
    @RequestMapping("/getAllBlog")
    public ModelAndView getAllBlog(
            @RequestParam("currentPage") Integer currentPage,@RequestParam(name = "msg",required = false) String msg
    ) {
        ModelAndView mv = new ModelAndView();
        if(msg!=null && msg.equals("发表成功")){
            mv.addObject("msg","发表成功");
        }else if( msg!=null && msg.equals("发表失败")){
            mv.addObject("msg","发表失败");
        }
        List<User> userlist = new ArrayList<>();
        Integer size = 10;
        String sortType = "DESC";
        String[] sortableFields = {"goodNum"};
        mv.setViewName("blog");

        Page<HealthBlog> page = healthBlogService.findAllPageable(currentPage,size,sortType,sortableFields);
        List<HealthBlog> list = new ArrayList<>();
        page.get().forEach(x -> list.add(x));
        List<BlogImg> imglist = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            User user = userService.getOne(list.get(i).getUserId());
            userlist.add(user);
            BlogImg blogImg = blogImgService.getOne(list.get(i).getImgId());
            imglist.add(blogImg);
        }

        if(currentPage==null){
            currentPage=1;
        }

        mv.addObject("bloglist",list);
        mv.addObject("userlist",userlist);
        mv.addObject("currentPage",currentPage);
        mv.addObject("totalPage",page.getTotalPages());
        mv.addObject("imglist",imglist);
        return mv;
    }

    ///////////////
    @RequestMapping("/managerblogall")
    public ModelAndView managerblogall(@RequestParam("currentPage") Integer currentPage){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("managerBlog");

        if(currentPage==null || currentPage<1){
            currentPage=1;
        }

        Integer size = 10;
        String sortType = "DESC";
        String[] sortableFields = {"goodNum"};

        Page<HealthBlog> page = healthBlogService.findAllPageable(currentPage,size,sortType,sortableFields);

        if(currentPage > page.getTotalPages()){
            currentPage = page.getTotalPages();
            page = healthBlogService.findAllPageable(currentPage,size,sortType,sortableFields);
        }

        List<HealthBlog> list = new ArrayList<>();
        page.get().forEach(x -> list.add(x));



        mv.addObject("bloglist",list);
        mv.addObject("currentPage",currentPage);
        mv.addObject("totalPage",page.getTotalPages());

        return mv;
    }

    @RequestMapping("/managerblogdelete")
    public ModelAndView managerblogdelete(Integer blogid){
        ModelAndView mv = new ModelAndView();
        HealthBlog healthBlog = healthBlogService.getOne(blogid);
        healthBlogService.delete(healthBlog);
        mv.addObject("currentPage",1);
        mv.setViewName("redirect:managerblogall");
        return mv;
    }
}
