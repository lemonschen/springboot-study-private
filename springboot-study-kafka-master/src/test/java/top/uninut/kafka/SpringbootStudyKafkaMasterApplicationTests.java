package top.uninut.kafka;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.uninut.kafka.service.KafkaProducer;

@SpringBootTest
class SpringbootStudyKafkaMasterApplicationTests {

    private KafkaProducer producer;

    @Autowired
    public SpringbootStudyKafkaMasterApplicationTests(KafkaProducer producer){
        this.producer = producer;
    }

    @Test
    void contextLoads() {
    }

    @Test void kafkaProducer(){
        this.producer.send();
    }

}
