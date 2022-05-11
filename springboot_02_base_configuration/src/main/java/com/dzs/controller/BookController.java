package com.dzs.controller;

import com.dzs.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    // 读取yml文件中的数据
    @Value("${country}")
    private String country;

    @Value("${a.b.c.d.e}")
    private String name;

    @Value("${likes[1]}")
    private String likes1;

    // 使用自动装配将所有yml配置装配
    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;

    @GetMapping
    public String getById(){
        System.out.println("springboot is running...");
        System.out.println("country====>"+country);
        System.out.println("username====>"+name);
        System.out.println("likes1====>"+likes1);
        System.out.println("_-----------------");
        System.out.println("env====>"+env);
        System.out.println(env.getProperty("likes[1]"));
        System.out.println("_-----------------");
        System.out.println("mydatasource====>>"+myDataSource.getUrl());

        return "springboot is running";
    }
}
