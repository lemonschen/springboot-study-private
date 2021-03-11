package top.uninut.core.socket;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;

public class SocketBusServer {
    /** Singleton Pattern */
    private static volatile SocketBusServer socketBusServer;
    private SocketBusServer(){};
    public static SocketBusServer getSocketBusServer(){
        if(socketBusServer == null){
            synchronized (SocketBusServer.class){
                if(socketBusServer == null){
                    return socketBusServer = new SocketBusServer();
                }
            }
        }
        return socketBusServer;
    }

    private final Set<Room> roomSet = new CopyOnWriteArraySet<>();
    private final Set<User> userSet = new CopyOnWriteArraySet<>();
    private final AtomicInteger roomId = new AtomicInteger(0);
    private final AtomicInteger userId = new AtomicInteger(0);

    public List<Room> getRoomList(){
        return new ArrayList<Room>(roomSet);
    }

    public List<User> getUserList(){
        return new ArrayList<User>(userSet);
    }

    public boolean addRoom(Room room){
        return roomSet.add(room);
    }

    public boolean addUser(User user){
        return userSet.add(user);
    }

    public int getRoomId(){
        return roomId.incrementAndGet();
    }

    public int getUserId(){
        return userId.incrementAndGet();
    }
}
