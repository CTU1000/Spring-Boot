package com.example.demo.controller;


import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * @Description
 * @Author RuYuFeng
 * @Date 2018/8/7 0007
 */
@RestController
public class TestController {

    @Autowired
    UserDao userDao;

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String test(){
        return "test success!";
    }

    @RequestMapping("/getUser")
    @Cacheable(value="key-Users")
    public User getUser(){
        User user = userService.selectByPrimaryKey(1);

        //user.setUserName("小米");
        //user.setPassWord("xxx");
        return user;
    }

    @RequestMapping("/getUserCache")
    @Cacheable(value="key-Users")
    public User getUserCache(){
        User user = userDao.findByUserName("aa");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/uid")
    String uid (HttpSession session){
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}
