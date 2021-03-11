package top.uninut.core.practice.socket;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TestSocketServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(48001);
            Socket socket = serverSocket.accept();

            BufferedReader socketIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            PrintWriter socketOut = new PrintWriter(socket.getOutputStream());

            while (true){

                String msg = socketIn.readLine();
                if(!StringUtils.isEmpty(msg)){
                    System.out.println(LocalDateTime.now()+" Server Get Message : "+msg);
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
