package top.uninut.kafka.common;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Message {
    private Long id;
    private String msg;
    private LocalDateTime sendTime;
}
