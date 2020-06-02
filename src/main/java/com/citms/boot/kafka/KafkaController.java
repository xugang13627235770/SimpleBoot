package com.citms.boot.kafka;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.UUID;

/**
 * 类HelloController的实现描述：TODO 类实现描述 
 * @author DELL 2020/5/28 10:11
 */
@RestController
public class KafkaController {

    @Resource
    private KafkaTemplate  defaultKafkaTemplate;

    @RequestMapping("/testKafka")
    public void testKafka(){
        Order order = new Order();
        order.setId("201905200000002");
        order.setName("测试Kafka");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        defaultKafkaTemplate.send("test1", JSON.toJSONString(order));
    }

    @Data
    class Order implements Serializable {

        private static final long serialVersionUID = -1844786744376934382L;

        private String id;
        private String name;
        private String messageId;  //存储消息发送的唯一标识

        public Order() {
            super();
        }

        public Order(String id, String name, String messageId) {
            super();
            this.id = id;
            this.name = name;
            this.messageId = messageId;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getMessageId() {
            return messageId;
        }

        public void setMessageId(String messageId) {
            this.messageId = messageId;
        }

    }
}
