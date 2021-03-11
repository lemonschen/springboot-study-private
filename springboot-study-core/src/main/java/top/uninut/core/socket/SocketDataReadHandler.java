package top.uninut.core.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class SocketDataReadHandler implements Runnable{

    private Socket socket;

    public SocketDataReadHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dis = null;
        try{
            while(true){
                //读取客户端数据
                dis = new DataInputStream(socket.getInputStream());
                String receiver = dis.readUTF();
                System.out.println(receiver);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(dis != null){
                    dis.close();
                }
                if(socket != null){
                    socket = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
