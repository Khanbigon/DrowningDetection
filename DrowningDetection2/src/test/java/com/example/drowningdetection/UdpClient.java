package com.example.drowningdetection;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class UdpClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");
            Random random = new Random();

            // 模拟多个用户的心率数据发送
            int[] deviceIds = {1, 2, 3}; // 三个用户
            for (int i = 0; i < 100; i++) {
                for (int deviceId : deviceIds) {
                    int heartRate = 45 + random.nextInt(50); // 模拟心率在45到95之间
                    int locationX = random.nextInt(20);
                    int locationY = random.nextInt(20);
                    String message = "deviceId:" + deviceId + ",heartRate:" + heartRate+",locationX:" + locationX + ",locationY:" + locationY;
                    byte[] buffer = message.getBytes();
                    DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 9876);
                    socket.send(packet);
                }
                Thread.sleep(1000); // 每秒发送一次
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
