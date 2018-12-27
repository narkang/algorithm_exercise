package com.narkang.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.UUID;

/**
 * UDP提供者 用于提供服务
 */
public class UDPProvider {

    public static void main(String[] args) throws IOException {
        String sn = UUID.randomUUID().toString();
        Provider provider = new Provider(sn);
        provider.start();

        System.in.read();
        provider.exit();
    }

    private static class Provider extends Thread {

        private DatagramSocket ds;
        private boolean done = false;
        private final String sn;

        public Provider(String sn){
            super();
            this.sn = sn;
        }

        @Override
        public void run() {
            super.run();

            System.out.println("UDPProvider started");

            try {
                //作为接受实体，指定一个端口用于数据接收
                ds = new DatagramSocket(20000);
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
                    System.out.println("UDPProvider receiver from ip:" + ip + "\tport:" + port + "\tdata:" + data);

                    //构建一份回送信息
                    int responsePort = MessageCreator.INSTANCE.parsePort(data);
                    if(responsePort != -1){
                        String responseData = MessageCreator.INSTANCE.buildWithSn(sn);
                        byte[] responseDataBytes = responseData.getBytes();
                        //直接根据发送者构建一份会送信息
                        DatagramPacket responsePacket = new DatagramPacket(responseDataBytes,
                                responseDataBytes.length,
                                receiverPack.getAddress(),
                                responsePort);
                        //信息发送会去
                        ds.send(responsePacket);
                    }
                }
            } catch (IOException e) {
//                e.printStackTrace();
            } finally {
                close();
            }
            //完成
            System.out.println("UDPProvider Finished");
        }

        private void close() {
            if (ds != null) {
                ds.close();
                ds = null;
            }
        }

        private void exit() {
            done = true;
            close();
        }
    }
}
