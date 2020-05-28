package com.citms.boot.threadpool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类HelloController的实现描述：TODO 类实现描述 
 * @author DELL 2020/5/28 10:11
 */
@RestController
public class ThreadController {

    @Autowired
    private ThreadPoolTaskExecutor pushTaskExecutor;

    @RequestMapping("/thread")
    public String hello(){
        for(int i=0;i<1000;i++){
            int finalI = i;
            pushTaskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    info(finalI);
                }
            });
            System.out.println("start---------------------------------= "+finalI);
            System.out.println("当前活动线程数："+ pushTaskExecutor.getActiveCount());
            System.out.println("核心线程数："+ pushTaskExecutor.getCorePoolSize());
            System.out.println("总线程数："+ pushTaskExecutor.getPoolSize());
            System.out.println("最大线程池数量"+pushTaskExecutor.getMaxPoolSize());
            System.out.println("线程处理队列长度"+pushTaskExecutor.getThreadPoolExecutor().getQueue().size());
            System.out.println("end---------------------------------= "+finalI);
        }

        return "hello";
    }

    private static void info(int i){
        System.out.println("线程执行开始-----"+i);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程执行完毕-----"+i);
    }
}
