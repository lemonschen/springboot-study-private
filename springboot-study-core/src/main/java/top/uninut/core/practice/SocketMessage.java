package top.uninut.core.practice;

import lombok.Data;

@Data
public class SocketMessage {
    private SocketUser socketUser;
    private String message;
}
