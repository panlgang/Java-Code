package com.excellent.chartroom.client.multi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/5/8 9:34
 */
public class Send extends Thread  {
    private Socket socket = null;
    public Send(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        menu();
        System.out.println("请输入：");
        while(true){
            try {
                OutputStream out = this.socket.getOutputStream();
                PrintStream write = new PrintStream(out);
                Scanner input = new Scanner(System.in);
                String message = input.nextLine();
                write.println(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void menu(){
        System.out.println("===============提示============");
        System.out.println("   注册格式： regisert:xxx");
        System.out.println("   群聊格式： group:xxx");
        System.out.println("   私聊格式： private:xxx:yyy");
        System.out.println("   退出格式： quit");
        System.out.println("xxx: 用户名" + "   " + "yyy : 消息");
        System.out.println("==================================");
    }
}
