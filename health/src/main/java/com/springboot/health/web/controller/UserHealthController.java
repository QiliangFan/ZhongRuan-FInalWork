package com.springboot.health.web.controller;

import com.springboot.health.dao.UserHealthDao;
import com.springboot.health.domain.po.HealthScore;
import com.springboot.health.domain.po.User;
import com.springboot.health.domain.po.UserHealth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserHealthController {
    @Autowired
    private UserHealthDao userHealthDao;

    @GetMapping("/healthresult")
    @ResponseBody
    public List<HealthScore> healthresult(@SessionAttribute User user){
        List<HealthScore> scorelist = new ArrayList<>();
        List<UserHealth> healthlist = userHealthDao.findAllByUserid(user.getId());
//        List<UserHealth> healthlist = userHealthDao.findAllByUserid(2);
        for(int i=0;i<healthlist.size();i++){
            UserHealth userHealth = healthlist.get(i);
            HealthScore healthScore = new HealthScore(userHealth.getHeight(),userHealth.getWeight(),userHealth.getWaist(),userHealth.getVision(),userHealth.getHeartRate());
            scorelist.add(healthScore);
        }
        return scorelist;
    }
}
