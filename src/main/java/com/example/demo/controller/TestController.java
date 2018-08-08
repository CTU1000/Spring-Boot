package com.example.demo.controller;


import com.example.demo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author RuYuFeng
 * @Date 2018/8/7 0007
 */
@RestController
public class TestController {

    @RequestMapping("/")
    public String test(){
        return "test success!";
    }

    @RequestMapping("/getUser")
    public User getUser(){
        User user = new User();
        user.setUserName("小米");
        user.setPassWord("xxx");
        return user;
    }
}
