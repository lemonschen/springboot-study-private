package top.uninut.core.practice;

import lombok.Data;

@Data
public class SocketUser {
    private int id;
    private String uuid;
    private String name;

    @Override
    public int hashCode(){
        return id;
    }

    @Override
    public boolean equals(Object object){
        SocketUser user = (SocketUser)object;
        return id == user.id && uuid.equals(user.uuid) && name.equals(user.name);
    }
}
