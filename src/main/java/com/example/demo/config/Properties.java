package com.example.demo.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Description 自定义配置文件 属性在application.properties
 * @Author RuYuFeng
 * @Date 2018/8/8 0008
 */
@Setter
@Getter
public class Properties {

    @Value("$(title)")
    private String title;

    @Value("$(description)")
    private String desc;
}
