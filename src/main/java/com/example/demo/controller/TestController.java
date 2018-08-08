package com.example.demo.controller;


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
}
