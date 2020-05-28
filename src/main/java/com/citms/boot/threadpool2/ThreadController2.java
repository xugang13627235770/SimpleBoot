package com.citms.boot.threadpool2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类HelloController的实现描述：TODO 类实现描述 
 * @author DELL 2020/5/28 10:11
 */
@RestController
public class ThreadController2 {

    @Autowired
    private CallThreadDemo worker;

    @RequestMapping("/thread2")
    public String hello(){
        for(int i=0;i<20;i++){
            System.out.println("controller开始--------------"+i);
            worker.callRong360(i);
            System.out.println("controller  end --------------");
        }
        return "hello";
    }
}
