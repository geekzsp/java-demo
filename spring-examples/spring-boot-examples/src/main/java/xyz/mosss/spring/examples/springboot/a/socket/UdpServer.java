package xyz.mosss.spring.examples.springboot.a.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.charset.StandardCharsets;

public class UdpServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(6667);
        while (true) {
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(packet);
            String s = new String(packet.getData(), packet.getOffset(), packet.getLength(), StandardCharsets.UTF_8);
            System.out.println("收到的数据：" + s);
            // 发送数据:
            byte[] data = "ACK".getBytes(StandardCharsets.UTF_8);
            packet.setData(data);
            datagramSocket.send(packet);
        }
    }
}