package com.citms.boot.mq;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.UUID;

/**
 * 类HelloController的实现描述：TODO 类实现描述 
 * @author DELL 2020/5/28 10:11
 */
@RestController
public class RabbitMqController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping("/testMq")
    public void testMq(){
        Order order = new Order();
        order.setId("201905200000001");
        order.setName("测试RabbitMq");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());

        //消息唯一ID
        CorrelationData correlationData = new CorrelationData(order.getMessageId());

        rabbitTemplate.convertAndSend("Udsp.Exchange.Default",
                "Udsp.Routing.#",
                JSONObject.toJSONString(order),         //消息体内容
                correlationData);   //消息唯一ID
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
