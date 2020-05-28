package com.citms.boot.threadpool2;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * 类ServiceParent的实现描述：TODO 类实现描述 
 * @author DELL 2020/5/27 17:00
 */
public abstract class ServiceParent implements Runnable {

    public JSONObject callBandBankMethod(String method,
                                         Map<String, Object> map) {

        return new JSONObject();
    }

    public abstract void run();
}
