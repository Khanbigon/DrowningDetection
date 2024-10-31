package com.example.drowningdetection2.component;

import com.example.drowningdetection2.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

@Component
public class UdpServerComponent {

    private static final int PORT = 9876;

    @Autowired
    private SensorDataService sensorDataService;

    @PostConstruct
    public void init() {
        new Thread(() -> {
            try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
                byte[] receiveData = new byte[1024];
                while (true) {
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    serverSocket.receive(receivePacket);
                    String sentence = new String(receivePacket.getData(), 0, receivePacket.getLength());
                    System.out.println("RECEIVED: " + sentence);
                    handleReceivedData(sentence);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void handleReceivedData(String data) {
        sensorDataService.processData(data);
    }
}
