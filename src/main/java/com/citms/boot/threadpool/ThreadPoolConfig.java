package com.citms.boot.threadpool;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: ly
 * @Descriptions: 线程池属性
 */
@ConfigurationProperties(prefix = "task.pool")
@Data
@Component
public class ThreadPoolConfig {

    private int corePoolSize;

    private int maxPoolSize;

    private int keepAliveSeconds;

    private int queueCapacity;

}
