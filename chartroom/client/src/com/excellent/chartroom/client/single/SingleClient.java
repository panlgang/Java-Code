package com.excellent.chartroom.client.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/5/7 23:29
 */
public class SingleClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6666;
        try {
            Socket socket = new Socket(host,port);
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            Scanner input = new Scanner(in);
            PrintStream printStream = new PrintStream(out);
            printStream.println("收到请回复，Over");
            printStream.flush();
            System.out.println(input.next());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
