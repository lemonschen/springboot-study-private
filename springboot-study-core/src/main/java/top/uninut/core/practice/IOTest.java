package top.uninut.core.practice;

import java.io.*;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class IOTest {
    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        String str = "测试";
        try {
            FileOutputStream fos = new FileOutputStream(new File("E://Desktop//test.txt"));
            try {
                fos.write(str.getBytes("UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void test2(){
        try {
            FileInputStream fis = new FileInputStream(new File("E://Desktop//test.txt"));
            byte[] content;
            try {
                int len = fis.read();
                content = new byte[len];
                fis.read(content);
                System.out.println(new String(content,"UTF-8"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void test3(){
        PipedOutputStream pos = new PipedOutputStream();
    }

    public static void test0(){
        InputStream inputStream;
        ByteArrayInputStream byteArrayInputStream;
        FileInputStream fileInputStream;
        FilterInputStream filterInputStream;
        InflaterInputStream inflaterInputStream;
        BufferedInputStream bufferedInputStream;
        ZipInputStream zipInputStream;
        DataInputStream dataInputStream;
        ObjectInputStream objectInputStream;
        PipedInputStream pipedInputStream;

        OutputStream outputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        FileOutputStream fileOutputStream;
        FilterOutputStream filterOutputStream;
        DataOutputStream dataOutputStream;
        PrintStream printStream;
        ZipOutputStream zipOutputStream;
        ObjectOutputStream objectOutputStream;
        PipedOutputStream pipedOutputStream;
    }
}
