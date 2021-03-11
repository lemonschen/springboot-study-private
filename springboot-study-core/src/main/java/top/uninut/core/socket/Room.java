package top.uninut.core.socket;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class Room implements Runnable{
    private int id;
    private String name;
    private String describe;
    private List<User> userList;
    private int port;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private boolean live = true;

    public Room(String name,String describe,int port,List<User> userList){
        this.id = SocketBusServer.getSocketBusServer().getRoomId();
        this.name = name;
        this.describe = describe;
        this.port = port;
        this.userList = userList;
    }

    public void shutdown(){
        this.live = false;
    }

    /**
     * 只能借助GUI了
     */
    @Override
    public void run() {

    }

    @Override
    public String toString(){
        return "ID: " + id +
                "\n群名: " + name +
                "\n描述: " + describe +
                "\n端口: " + port +
                "\n人数: " + userList.size();
    }
}
