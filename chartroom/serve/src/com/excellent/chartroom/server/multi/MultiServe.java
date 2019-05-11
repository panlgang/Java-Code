package com.excellent.chartroom.server.multi;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther plg
 * @date 2019/5/8 9:46
 */
public class MultiServe {
    private static final ExecutorService executor = Executors.newFixedThreadPool(10,
            r ->{
            final AtomicInteger id = new AtomicInteger(0);
            Thread t = new Thread(r);
            t.setName("Thread-Hander-" + id.getAndIncrement());
            return t;
    });

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("服务器已启动" + serverSocket.getInetAddress() + "  " + serverSocket.getLocalPort() +"等待客户端连接......");
            while(true){
                final Socket socket = serverSocket.accept();
                System.out.println("客户端，连接成功。。");
                executor.execute(new ClinetHander(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

