package com.github.excellent01;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/5/11 0:00
 */
public class ReceiveMessage extends Thread {
    private Socket socket = null;
    public ReceiveMessage(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        while (true){
            try {
                InputStream in = this.socket.getInputStream();
                Scanner input = new Scanner(in);
                String message = input.nextLine();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {

            }
        }
    }
}
