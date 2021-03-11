package top.uninut.core.practice.socket;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TestSocketClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 48001);
            BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter socketOut = new PrintWriter(socket.getOutputStream());
            while (true){

                String readline = systemIn.readLine();

                if(!StringUtils.isEmpty(readline)){
                    socketOut.println(readline);
                    socketOut.flush();
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
