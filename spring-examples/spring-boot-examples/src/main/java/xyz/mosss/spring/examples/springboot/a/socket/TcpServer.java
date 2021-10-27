package xyz.mosss.spring.examples.springboot.a.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务端启动 监听6666端口");
        while (true) {
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String s = dataInputStream.readUTF();
            System.out.println("收到的消息：" + s);
            OutputStream outputStream = accept.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("echo:" + s);
        }
    }
}