package com.citms.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类HelloController的实现描述：TODO 类实现描述 
 * @author DELL 2020/5/28 10:11
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
