package com.springboot.health.web.controller;

import com.springboot.health.biz.HistoryService;
import com.springboot.health.biz.UserHealthService;
import com.springboot.health.biz.UserService;
import com.springboot.health.dao.HistoryDao;
import com.springboot.health.dao.UserHealthDao;
import com.springboot.health.domain.po.HealthBlog;
import com.springboot.health.domain.po.History;
import com.springboot.health.domain.po.User;
import com.springboot.health.domain.po.UserHealth;
import com.springboot.health.utils.CodeUtil;
import com.springboot.health.utils.MD5;
import com.springboot.health.utils.SendEmail;
import com.springboot.health.utils.SendMessageUtil;
import com.sun.media.sound.ModelDirectedPlayer;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.io.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Null;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.springboot.health.utils.MD5.getMd5;
import static com.springboot.health.utils.SendMessageUtil.getRandomCode;

/**
 * @author chentaijie
 * @version 1.0
 * @date 2019/8/10 22:00
 */
@Controller
public class UserController {
    @Autowired
    JavaMailSenderImpl mailSender;

    @Autowired
    private UserService userService;

    @Autowired
    private HistoryDao historyDao;

    @Autowired
    private UserHealthDao userHealthDao;

    @RequestMapping("/Register")
    public String save(Model model ,User user, HttpSession session, HttpServletRequest request) {
        if (CodeUtil.checkVerifyCode(request)) {
            {
                User user2 = userService.findByName(user.getName());
                if (user2 == null/*||user2.getAuthority().equals("-1")*/) {
                    String md5pwd = getMd5(user.getPassword());
                    user.setPassword(md5pwd);
                    if(user.getGender().equals("Female")){
                        user.setHeadimage("headImage/girl.jpeg");
                    }else if(user.getGender().equals("Male")){
                        user.setHeadimage("headImage/boy.jpg");
                    }else if(user.getGender().equals("Secret")){
                        user.setHeadimage("headImage/secret.png");
                    }
                    user.setAuthority("0");              //初始化为普通用户权限
                    User user1 = userService.save(user);
                    session.setAttribute("user", user1);
                    return "index";
                } else {
                    model.addAttribute("msg","该用户已存在");
//                    session.setAttribute("msg", "该用户已存在");
                    return "login";
                }
            }
        } else {
            model.addAttribute("msg","验证码错误");
//            session.setAttribute("msg", "验证码错误");
            return "register";
        }
    }

    @RequestMapping("/Login")
    public String login(Model model,String name, String password, String authority, HttpSession session, HttpServletRequest request) {
        if (CodeUtil.checkVerifyCode(request)) {
            User user1 = userService.findByName(name);
            if (user1 != null&&!user1.getAuthority().equals("-1")) {
                if (user1.getPassword().equals(getMd5(password))) {     //password需要替换回去getMd5(password)
                    session.setAttribute("user", user1);
                    if(user1.getAuthority().equals(authority)&&"1".equals(authority)){
                        return "redirect:toDashBoard";
                    }else{
                        return "index";
                    }
                } else {
                    model.addAttribute("msg","用户名或密码错误");
//                    session.setAttribute("msg", "用户名或密码错误");
                    return "login";
                }
            } else {
                model.addAttribute("msg","用户名或密码错误");
//                session.setAttribute("msg", "用户名或密码错误");
                return "login";
            }
        } else {
            model.addAttribute("msg","验证码错误");
//            session.setAttribute("msg", "验证码错误");
            return "login";
        }

    }

    @RequestMapping("/Logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.removeAttribute("pcode");
        session.removeAttribute("ecode");
        session.removeAttribute("users");
        return "index";
    }

    @RequestMapping("/Findpwd")
    public String Findpwd(HttpSession session) {
        return "findpwd1";
    }

    @RequestMapping("/Findpwd1")
    public String findpwd1(Model model, String name, HttpSession session) {
        User user = userService.findByName(name);
        if (user != null) {
            String uuid = (String) UUID.randomUUID().toString().replaceAll("-", "").substring(0, 4);
            session.setAttribute("ecode",uuid);
            session.setAttribute("uname",name);
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("通知-今晚开会");
            message.setText("您好，感谢您使用我们的健康平台\n检测到您可能会更改密码\n为您提供验证码如下" + uuid);
            message.setTo(user.getEmail());
            message.setFrom("juminjiankangxinxi@163.com");
            mailSender.send(message);
            return "findpwd2";
        } else {
            model.addAttribute("msg","不存在该用户");
            return "findpwd1";
        }
    }

    @RequestMapping("Findpwd2")
    public String findpwd2(Model model,String code, String password, String password2, HttpSession session) {
        String ecode = (String)session.getAttribute("ecode");
        String name = (String)session.getAttribute("uname");
        if (code.equals(ecode)) {
            if (password.equals(password2)) {
                String md5pwd = MD5.getMd5(password);
                User user = userService.findByName(name);
                user.setPassword(md5pwd);
                userService.save(user);
                session.setAttribute("user", user);
                return "index";
            } else {
                model.addAttribute("msg","两次密码输入不一致");
//                session.setAttribute("msg", "两次密码输入不一致");
                return "login";
            }
        } else {
            model.addAttribute("msg","验证码输入错误");
            //session.setAttribute("msg", "验证码输入错误");
            return "login";
        }

    }

    /*
     * Edit <= LIANG
     */
    @RequestMapping("/userInfo_info")
    public String toUserInfo_info(@SessionAttribute(name = "user", required = false) User user) {
        //user为空?  如何处理!!!!!
        try {
            return "userInfo_info";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }
    }

    /*
     * Edit <= LIANG
     */
    @RequestMapping("/userInfo_history")
    public String toUserInfo_history(HttpServletRequest request,@SessionAttribute(name="user",required = false) User user) {
        //思考: 是否要验证session过期
        try {
            List<History> historyLists=historyDao.findByUserid(user.getId());
            request.setAttribute("historyLists", historyLists);
            System.out.println(historyLists);
            return "userInfo_history";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }
    }

    /*
     * Edit <= LIANG
     */
    @RequestMapping("/userInfo_health")
    public String toUserInfo_health() {
        try {
            return "userInfo_health";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/";
        }
    }

    @RequestMapping("/modifyUserInfo")
    public String modifyUserInfo(@SessionAttribute(name="user",required = false) User user,
                                @RequestParam("birthday") String birthday,
                                 @RequestParam("password") String password,
                                 @RequestParam("headimage") MultipartFile multipartFile) throws IOException {
        try {
            String path = UserController.class.getClassLoader().getResource(".") + "static/headImage";
            path = path.replace("file:", "");
            String type = multipartFile.getContentType();
            Boolean canIupload = true;
            String url = null;
            if (type.equals("image/jpeg")) {
                type = "jpeg";
            } else if (type.equals("image/png")) {
                type = "png";
            } else if (type.equals("image/gif")) {
                type = "gif";
            } else {
                canIupload = false;
            }
            if (canIupload) {
                String fileName = String.valueOf(multipartFile.hashCode());
                File file = new File(path + "/" + fileName + "." + type);
                System.out.println(file);
                FileUtils.copyInputStreamToFile(multipartFile.getInputStream(), file);
                url = "headImage/" + fileName + "." + type;
            }
            User u = new User();
            u.setEmail(user.getEmail());
            u.setBirthday(user.getBirthday());
            u.setPassword(MD5.getMd5(password));
            u.setName(user.getName());
            u.setAuthority(user.getAuthority());
            u.setPhone(user.getPhone());
            if(url!=null) u.setHeadimage(url);
            else u.setHeadimage(user.getHeadimage());
            u.setGender(user.getGender());
            u.setId(user.getId());
            userService.save(u);
            return "userInfo_info";
        }catch (Exception e){
            e.printStackTrace();
            return "userInfo_info";
            //return "redirect:/";
        }
    }
    @RequestMapping("/modifyUserHealth")
    public String modifyUserHealth(UserHealth userHealth,@SessionAttribute(name = "user",required = false)User user){
        UserHealth uh = new UserHealth();
        if(userHealth.getAge()!=null) uh.setAge(userHealth.getAge());
        if(userHealth.getHeight()!=null) uh.setHeight(userHealth.getHeight());
        if(userHealth.getWeight()!=null) uh.setWeight(userHealth.getWeight());
        if(userHealth.getWaist()!= null) uh.setWaist(userHealth.getWaist());
        if(userHealth.getVision()!=null) uh.setVision(userHealth.getVision());
        if(userHealth.getHeartRate()!=null) uh.setHeartRate(userHealth.getHeartRate());
        if(userHealth.getGender()!=null) uh.setGender(userHealth.getGender());
        SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String myTime = sfd.format(new Date());
        uh.setTime(myTime);
        uh.setUserid(user.getId());

        System.out.println(uh);
        userHealthDao.save(uh);
        return "userInfo_health";
    }


    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User modifyUserInfo(@SessionAttribute(name="user",required = false)User user){
        try {
            User u = userService.findByName(user.getName());
            System.out.println(u);
            return u;
        }catch (Exception e){
            return null;
        }
    }

    @RequestMapping("/sendvcode")
    public String sendvcode(Model model,String phone, HttpSession session){
        if(userService.findByPhone(phone) != null){
            SendMessageUtil.pcode = getRandomCode(6);
            User user = userService.findByPhone(phone);
            Integer resultCode = SendMessageUtil.send("yidongbuyijing","d41d8cd98f00b204e980",user.getPhone(),"验证码："+ SendMessageUtil.pcode);
            System.out.println(SendMessageUtil.getMessage(resultCode));
            if(resultCode>0){
                session.setAttribute("pcode", SendMessageUtil.pcode);
                session.setAttribute("phone", phone);
                return "loginbyphone2" ;
            }else{
                model.addAttribute("msg","发送短信验证码失败，请检查手机号码是否输入正确");
                return "loginbyphone";
            }


        }else{
            model.addAttribute("msg","手机号码错误");
//            session.setAttribute("msg","手机号码错误");
            return "loginbyphone";
        }
    }

    @RequestMapping("/LoginByPhone")
    public String LoginByPhone(Model model,String pcode1,String authority,HttpSession session){
        String pcode2 =(String)session.getAttribute("pcode");
        if(pcode2.equalsIgnoreCase(pcode1)){
            String phone = (String)session.getAttribute("phone");
            User user = userService.findByPhone(phone);
            session.setAttribute("user",user);
            if(user.getAuthority().equals("1")&&authority.equals("1")){
                        return "manageruser";
            }else{
                return "index";
            }
        }else{
            model.addAttribute("msg","验证码错误");
            return "loginbyphone2";
        }
    }

    @RequestMapping(value= "/alterauthority"/*,method = RequestMethod.GET*/)
    public ModelAndView alterauthority(@RequestParam("currentPage") Integer currentPage, HttpServletRequest request){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("manageuser");
        String name = request.getParameter("name");
            String authority = request.getParameter("authority");
            User user = userService.findByName(name);
            if("-1".equals(authority)){
                user.setAuthority("-1");
                userService.save(user);
            }else{
                if(user.getAuthority().equals("0")){
                    user.setAuthority("1");
                    userService.save(user);
                }else{
                    user.setAuthority("0");
                    userService.save(user);
                }
            }
            List<User> list = userService.findAll();
            List<User> removelist = new ArrayList<>();
            for(User user2:list){
                if(user2.getAuthority().equals("-1")){
                    removelist.add(user2);
                }
            }
            if(removelist.size()>0){
                list.removeAll(removelist);
            }


            ///从这开始分页

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
            return mv;
        }

//        @RequestMapping(name = "alterauthority2"/*,method = RequestMethod.GET*/)
//        public String alterauthority2(HttpSession session,HttpServletRequest request){
//            String name = request.getParameter("name");
//            User user = userService.findByName(name);
//            user.setAuthority("-1");
//            userService.save(user);
//            List<User> list = userService.findAll();
//            List<User> removelist = new ArrayList<>();
//            for(User user2:list){
//                if(user.getAuthority().equals("-1")){
//                    removelist.add(user2);
//                }
//            }
//            if(removelist.size()>0){
//                list.removeAll(removelist);
//            }
//            session.setAttribute("users",list);
//                return "manageruser";
//        }
}
