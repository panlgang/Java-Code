package com.github.excellent01;

import java.io.*;
import java.net.Socket;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @auther plg
 * @date 2019/5/10 22:11
 */
public class HandelClient implements Runnable {
    private Socket socket = null;
    private String name = null;
    private static final ConcurrentHashMap<Socket,String> SOCKET_MAP = new ConcurrentHashMap<>();
    private static final CopyOnWriteArraySet USER_SET = new CopyOnWriteArraySet();
    public HandelClient(Socket socket){
        this.socket = socket;
    }
    static class User{
        private String username;
        private String password;
        private File file = null;
        public User(String username, String password,File file) {
            this.username = username;
            this.password = password;
            this.file = file;
        }
        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(username, user.username) &&
                    Objects.equals(password, user.password);
        }

        @Override
        public int hashCode() {

            return Objects.hash(username, password);
        }
    }
    @Override
    public void run() {
        while(true){
            String message = readMessage(this.socket);
            if(message.startsWith("register")){
                // register:username:pwd;
                String[] arr = message.split(":");
                if(arr.length == 3 && arr[0].equals("register")){
                    this.name = arr[1];
                    register(new User(name,arr[2],new File(arr[1] + ".txt")));
                    continue;
                }
            }
            if(message.startsWith("login")){
                //login:usename:pwd
                String[] arr = message.split(":");
                if(arr.length == 3 && arr[0].equals("login")){
                    this.name = arr[1];
                    login(arr[1],arr[2]);
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

            if(message.equals("quit")){
                quit();
                break;
            }
        }

    }

    private void login(String usenem, String password) {
        User user = new User(usenem,password);
        if(USER_SET.contains(user) && !SOCKET_MAP.contains(usenem)){
            SOCKET_MAP.put(this.socket,usenem);
            sendMessage(this.socket,"【系统消息】：" + "登录成功。");
            try {
                Scanner input = new Scanner(new FileInputStream(usenem + ".txt"));
                while(input.hasNext()){
                    sendMessage(this.socket,input.nextLine());
                }
                try {
                    Writer writer = new FileWriter(usenem + ".txt");
                    writer.write("");
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    //TODO
                }


            } catch (FileNotFoundException e) {
                //TODO
            }
        }else{
            sendMessage(this.socket,"【系统消息】：" + "登录失败。");
        }
    }

    private void quit() {
        String message =  "【系统消息】：" + this.name + "下线了。";
        System.out.println(message);
        sendMessage(this.socket,"【系统消息】：" + "下线成功。");
        SOCKET_MAP.remove(this.socket);
        printOnline();
    }

    private void privateChat(String goalName, String news) {
        news = "【" + this.name  + "】【私】" + "：" + news;
        for(Socket socket : SOCKET_MAP.keySet()){
            if(SOCKET_MAP.get(socket).equals(goalName)){
                sendMessage(socket,news);
                return;
            }else{
                try {
                    PrintStream printStream = new PrintStream(new FileOutputStream(goalName + ".txt"),true);
                    printStream.println(news);
                    printStream.flush();
                } catch (IOException e) {
                    //TODO
                }
            }
        }
    }


    private void register(User user) {
        if(!USER_SET.contains(user)) {
            SOCKET_MAP.put(this.socket, this.name);
            USER_SET.add(user);
            printOnline();
            sendMessage(this.socket,"【系统消息】：注册成功,开始快乐的聊天吧！");
        }else{
            sendMessage(this.socket,"【系统消息】：该用户已经注册过了,直接登陆即可。");
        }

    }

    private void groupChat(String news) {
        news = "【" + this.name  + "】【群】" + "：" + news;
        for(Socket socket : SOCKET_MAP.keySet()){
            if(socket != this.socket){
                sendMessage(socket,news);
            }
        }
    }

    private void sendMessage(Socket socket, String news) {
        try{
            OutputStream out = socket.getOutputStream();
            PrintStream output = new PrintStream(out);
            output.println(news);
            out.flush();
        }catch (IOException e){
            //TODO
        }
    }

    private String readMessage(Socket socket){
        String message = "";
        try{
            InputStream in = socket.getInputStream();
            Scanner input = new Scanner(in);
            message = input.nextLine();
        }catch (IOException e){
            //TODO  没读到数据
        }
        return message;
    }
    private void printOnline(){
        System.out.println("=======当前在线的用户名称=======");
        for(Socket socket : SOCKET_MAP.keySet()){
            System.out.print(SOCKET_MAP.get(socket) + "   ");
        }
        System.out.println();
    }


}
