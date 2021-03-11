package top.uninut.core.socket;

import java.util.List;

public class PrintHelper {
    public static void printHomePage(){
        System.out.println("********************************\n" +
                "*            聊天室菜单          *\n" +
                "*     1.查看房间列表             *\n" +
                "*     2.查看用户列表             *\n" +
                "*     3.创建房间                *\n" +
                "*     4.删除房间                *\n" +
                "*     5.创建用户                *\n" +
                "*     6.删除用户                *\n" +
                "********************************");
    }

    public static void clearScreen(){
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<50;i++){
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void printHomePageTip(){
        System.out.println("(输入0返回菜单)");
    }

    public static void printRoomList(List<Room> roomList){
        System.out.println("房间列表");
        for(int i=0;i<roomList.size();i++){
            System.out.println("["+(i+1)+"]  "+roomList.get(i).getName()+"@"+
                    roomList.get(i).getId()+"("+roomList.get(i).getUserList().size()+"人)");
        }
    }

    public static void printUserList(List<User> userList){
        System.out.println("用户列表");
        for(int i=0;i<userList.size();i++){
            System.out.println("["+(i+1)+"]  "+userList.get(i).getName()+"@"+
                    userList.get(i).getId()+"("+userList.get(i).getRoomList().size()+"房间)");
        }
    }

    public static void printRoom(Room room){
        System.out.println(room.toString());
    }

    public static void printUser(User user){
        System.out.println(user.toString());
    }
}
