package com.citms.boot.threadpool2;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

/**
 * 类CallThreadDemo的实现描述：TODO 类实现描述 
 * @author DELL 2020/5/27 16:49
 */
@Component
public class CallThreadDemo {
    //这里是Spring.xml中配置的bean名称
    @Autowired
    private ThreadPoolTaskExecutor pushTaskExecutor;

    public void callRong360(final int i) {
        //这个类是我封装的抽象类，里面有一个公共方法，具体代码下面有
        ServiceParent callRong360Method = new ServiceParent() {
            @Override
            public void run() {
                System.out.println("线程开始-------------"+i);//这里调用第三方公用接口
                try {
                    Thread.sleep(30000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                JSONObject result = callBandBankMethod(null, null);//这里调用service方法，实现自己的业务逻辑
                System.out.println(result);
                System.out.println("线程结束-------------"+i);

            }
        };//这里线程池方法调用一个线程继承类或者实现Runable接口的类
        pushTaskExecutor.execute(callRong360Method);

        System.out.println("当前活动线程数：" + pushTaskExecutor.getActiveCount());
        System.out.println("核心线程数：" + pushTaskExecutor.getCorePoolSize());
        System.out.println("总线程数：" + pushTaskExecutor.getPoolSize());
        System.out.println("最大线程池数量" + pushTaskExecutor.getMaxPoolSize());
        System.out.println("线程处理队列长度" + pushTaskExecutor.getThreadPoolExecutor().getQueue().size());
    }
}