package top.uninut.core.practice;

import java.io.*;
import java.util.zip.InflaterInputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class IOTest {
    public static void main(String[] args) {
        test0();
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
