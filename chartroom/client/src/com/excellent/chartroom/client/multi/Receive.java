package com.excellent.chartroom.client.multi;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/5/8 9:35
 */
public class Receive extends Thread {
    private Socket socket = null;
    public Receive(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        while (true){
            try {
                InputStream in = this.socket.getInputStream();
                Scanner read = new Scanner(in);
                String message = read.next();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
