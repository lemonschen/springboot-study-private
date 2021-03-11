package top.uninut.core.practice;

import top.uninut.core.socket.SocketDataReadHandler;
import top.uninut.core.socket.SocketDataWriteHandler;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class SocketServer {

    private static Map<SocketUser,Socket> socketMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = null;
        do {
            System.out.println("请输入房间名：");
            String text = scanner.next();
            if(text.trim().length() > 0){
                name = text.trim();
            }
        }while (name == null);

        int port = -1;
        do {
            System.out.println("请输入端口号：");
            String portString = scanner.next();
            try{
                port = Integer.parseInt(portString);
            }catch (Exception e){
                System.out.println("输入错误！");
            }

            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(port);

                while (true){
                    Socket socket = serverSocket.accept();
                    new Thread(new SocketDataReadHandler(socket)).start();
                    new Thread(new SocketDataWriteHandler(socket)).start();
                }

            }catch (Exception e){
                System.out.println("端口已被占用！");
            }finally {
                try {
                    if (serverSocket != null) {
                        serverSocket.close();
                    }
                }catch (Exception e){

                }
            }
        }while (port == -1);

    }
}
