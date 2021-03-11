package top.uninut.core.socket;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private int id;
    private String name;
    private Sex sex;
    private String describe;
    private List<Room> roomList;

    public static enum Sex{
        MALE,FEMALE
    }

    @Override
    public String toString(){
        return "ID: " + id +
                "\n昵称: " + name +
                "\n性别: " + sex +
                "\n签名: " + describe +
                "\n群数: " + roomList.size();
    }
}
