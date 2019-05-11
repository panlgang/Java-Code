package com.excellent.chartroom.client.multi;

import java.io.IOException;
import java.net.Socket;

/**
 * @auther plg
 * @date 2019/5/8 9:34
 */
public class MulitClient {
    public  static final String HOST = "127.0.0.1";
    public  static final int PORT = 8888;
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(MulitClient.HOST,MulitClient.PORT);
            Receive receive = new Receive(socket);
            receive.start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Send send = new Send(socket);
            send.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
