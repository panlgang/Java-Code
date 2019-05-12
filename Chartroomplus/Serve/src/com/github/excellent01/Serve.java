package com.github.excellent01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @auther plg
 * @date 2019/5/10 22:10
 */
public class Serve {
    private static AtomicInteger i = new AtomicInteger(1);
    private static int port;
    private static ExecutorService service =null;
    public static void main(String[] args) {
        // port = 8080  count = 10;
        int defaultPort = 8090;
        int defaultCount = 10;
        int port = defaultPort;
        int count = defaultCount;
        for(String arg : args){
            if(arg.startsWith("port=")){
                try{
                    String str = arg.substring("port=".length());
                    port = Integer.parseInt(str);
                }catch (NumberFormatException e){
                    port = defaultPort;
                }
            }
            if(arg.startsWith("count=")){
                try{
                    count = Integer.parseInt(arg.substring("count=".length()));
                }catch (NumberFormatException e){
                    count = defaultCount;
                }
            }
        }
        service = newIntence(count);
//        System.out.println(port);
////        System.out.println(count);
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("服务器已启动，等待连接......");
            System.out.println("本地地址：" + serverSocket.getInetAddress() + "  端口号： " +  serverSocket.getLocalPort());
            while(true) {
                Socket client = serverSocket.accept();
                System.out.println();
                System.out.println("有" + i.getAndIncrement()  + "用户连接成功");
                service.execute(new HandelClient(client));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ExecutorService newIntence(int count){
        final AtomicInteger num = new AtomicInteger(0);
        int coreSize = count >> 1;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(coreSize,count,50,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(10),r -> {
            Thread thread = new Thread(r);
            thread.setName("Thread--HandelClient--" + num.getAndIncrement());
            return thread;
        });
        return executor;
    }
}
