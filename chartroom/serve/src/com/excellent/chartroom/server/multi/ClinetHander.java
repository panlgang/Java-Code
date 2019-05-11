package com.excellent.chartroom.server.multi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @auther plg
 * @date 2019/5/8 9:47
 */
public class ClinetHander implements Runnable {
    private static  ConcurrentHashMap<Socket,String> socketMap = new ConcurrentHashMap();
    private final Socket socket;
    public ClinetHander(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = this.socket.getInputStream();
            Scanner read = new Scanner(in);
            while(true){
                String message = read.nextLine();
                if(message.equals("quit")){
                    quit();
                    return;
                }
                if(message.startsWith("register")){
                    String[] arr = message.split(":");
                    if(arr.length == 2 && arr[0].equals("register")){
                        String name = arr[1];
                        register(name);
                        continue;
                    }
                }
                if(message.startsWith("group")){
                    String[] arr = message.split(":");
                    if(arr.length == 2 && arr[0].equals("group")){
                        String news  = arr[1];
                        groupChat(news);
                        continue;
                    }
                }
                if(message.startsWith("private")){
                    String[] arr = message.split(":");
                    if(arr.length == 3 && arr[0].equals("private")){
                        String goalName = arr[1];
                        String news = arr[2];
                        privateChat(goalName,news);
                        continue;
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void register(String name){
        socketMap.put(this.socket,name);
        System.out.println("恭喜<" + name +  ">登陆 / 注册成功" );
        this.send("恭喜你--登陆/注册成功",this.socket);
    }
    private  void quit(){
        System.out.println(socketMap.get(this.socket) + "下线了");
        socketMap.remove(this.socket);
    }
    private void groupChat(String news){
        String sourceName = socketMap.get(this.socket);
        String message = "<" + sourceName + ">" + "说:" + news;
        this.send(message,null);
    }
    private void privateChat(String goalName,String news){
        String sourcrName = socketMap.get(this.socket);
        String message = "<" + sourcrName + ">" + "对你说:" + news;
        // 通过name获得socket
        Socket socket = null;
        for(Socket socket1 : socketMap.keySet()){
            if(socketMap.get(socket1).equals(goalName)){
                socket = socket1;
                break;
            }
        }
        if(socket != null){
            this.send(message,socket);
        }
    }
    private void send(String message,Socket socket){
        try {
            if(socket == null){  // 群发
                for(Socket socket1 : socketMap.keySet()){
                    OutputStream out = socket1.getOutputStream();
                    PrintStream printStream = new PrintStream(out);
                    printStream.println(message);
                }
            }else{   // 私聊
                for(Socket socket1 : socketMap.keySet()){
                    if(socket1 == socket) {
                        OutputStream out = socket1.getOutputStream();
                        PrintStream printStream = new PrintStream(out);
                        printStream.println(message);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void receive(){
        try {
            InputStream in = this.socket.getInputStream();
            Scanner input = new Scanner(in);
            String mmssge = input.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
