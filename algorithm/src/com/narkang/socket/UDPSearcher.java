package com.narkang.socket;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class UDPSearcher {
    private static final int LISTEN_PORT = 30000;
    private static void sendBroadcast() throws IOException {
        System.out.println("UDPSearcher sendBroadcast started.");
        DatagramSocket ds = new DatagramSocket();

        //构建请求数据
        String requestData = MessageCreator.INSTANCE.buildWithPort(LISTEN_PORT);
        byte[] requestDataBytes = requestData.getBytes();
        //直接构建packet
        DatagramPacket requestPacket = new DatagramPacket(requestDataBytes, requestDataBytes.length);
        requestPacket.setAddress(InetAddress.getByName("255.255.255.255"));
        requestPacket.setPort(20000);

        //发送
        ds.send(requestPacket);
        ds.close();

        System.out.println("UDPSearcher sendBroadcast finish.");
    }

    private static class Device{
        final int port;
        final String ip;
        final String sn;

        public Device(int port, String ip, String sn) {
            this.port = port;
            this.ip = ip;
            this.sn = sn;
        }

        @Override
        public String toString() {
            return "Device{" +
                    "port=" + port +
                    ", ip=" + ip +
                    ", sn=" + sn +
                    '}';
        }
    }

    private static class Listener extends Thread{
        private final int listenPort;
        private final CountDownLatch countDownLatch;
        private final List<Device> devices = new ArrayList<>();
        private boolean done = false;
        private DatagramSocket ds = null;

        public Listener(int listenPort, CountDownLatch countDownLatch){
            super();
            this.listenPort = listenPort;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            super.run();
            countDownLatch.countDown();
            try {
                //监听回送端口
                ds = new DatagramSocket(listenPort);
                while (!done) {
                    //构建接收实体
                    final byte[] buf = new byte[512];
                    DatagramPacket receiverPack = new DatagramPacket(buf, buf.length);
                    //接受
                    ds.receive(receiverPack);

                    // 打印接收到的信息与发送者的信息
                    String ip = receiverPack.getAddress().getHostAddress();
                    int port = receiverPack.getPort();
                    int dataLen = receiverPack.getLength();
                    String data = new String(receiverPack.getData(), 0, dataLen);
                    System.out.println("UDPSearcher receiver from ip:" + ip + "\tport:" + port + "\tdata:" + data);

                    String sn = MessageCreator.INSTANCE.parseSn(data);
                    if(sn != null){
                        devices.add(new Device(port, ip, sn));
                    }
                }
            } catch (IOException e) {
//                e.printStackTrace();
            } finally {
                close();
            }
        }

        private void close() {
            if (ds != null) {
                ds.close();
                ds = null;
            }
        }

        List<Device> getDevicesAndExit() {
            done = true;
            close();
            return devices;
        }
    }

    private static Listener listener() throws InterruptedException {
        System.out.println("UDPSearcher start listener");
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Listener listener = new Listener(LISTEN_PORT, countDownLatch);
        listener.start();

        countDownLatch.await();
        return listener;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("UDPSearcher started");

        Listener listener = listener();
        sendBroadcast();

        System.in.read();

        List<Device> devices = listener.getDevicesAndExit();
        devices.forEach(device -> System.out.println("Device:"+device.toString()));

        //完成
        System.out.println("UDPSearcher Finished");
    }
}
