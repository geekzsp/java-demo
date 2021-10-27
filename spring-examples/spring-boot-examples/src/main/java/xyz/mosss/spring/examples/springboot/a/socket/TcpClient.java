package xyz.mosss.spring.examples.springboot.a.socket;

import java.io.*;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        // 连接指定服务器和端口
        Socket socket = new Socket("localhost", 6666);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("你好");
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        System.out.println("客户端收到的消息: " + dataInputStream.readUTF());
    }
}