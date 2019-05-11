package com.excellent.chartroom.server.single;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/5/7 23:24
 */
public class SingleServe {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(6666);
            System.out.println("服务器已启动，等待连接......");
            Socket socket = serverSocket.accept();
            System.out.println("连接成功！！！！");
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            Scanner input = new Scanner(in);
            PrintStream printStream = new PrintStream(out);
            System.out.println(input.next());
            printStream.println("收到，收到 Over");
            printStream.flush();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
