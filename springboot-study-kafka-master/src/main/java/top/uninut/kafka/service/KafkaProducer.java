package top.uninut.kafka.service;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import top.uninut.kafka.common.Message;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String,String> template;

    @Autowired
    public KafkaProducer(KafkaTemplate template){
        this.template = template;
    }

    public void send(){
        Message message = new Message();
        message.setId(System.currentTimeMillis());
        message.setMsg(UUID.randomUUID().toString());
        message.setSendTime(LocalDateTime.now());
        log.info("kafka producer send message -> "+JSON.toJSONString(message));
        template.send("test", JSON.toJSONString(message));
    }
}
