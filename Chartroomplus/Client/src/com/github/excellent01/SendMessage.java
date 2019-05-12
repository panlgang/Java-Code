package com.github.excellent01;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/5/11 0:02
 */
public class SendMessage extends Thread {
    private Socket socket = null;
    public SendMessage(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        menu();
        System.out.print("请输入：");
        OutputStream out = null;
        PrintStream output = null;
        Scanner input = null;
        while(true){
            try {
                out = this.socket.getOutputStream();
                output = new PrintStream(out);
                input = new Scanner(System.in);
                //input.useDelimiter("\n");
                String message = input.nextLine();
                output.println(message);
                out.flush();
                if(message.equals("quit")){
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
//                try{
//                    out.close();
//                    input.close();
//                    output.close();
//                }catch (IOException e){
//                    //TODO  流的关闭
//                }
            }
        }
    }
    private void menu(){
        System.out.println("===============输入格式============");
        System.out.println("   注册格式： register:xxx:zzz");
        System.out.println("   登陆格式： login:xxx:zzz");
        System.out.println("   群聊格式： group:xxx");
        System.out.println("   私聊格式： private:xxx:yyy");
        System.out.println("   退出格式： quit");
        System.out.println("xxx: 用户名  zzz : 密码" + "yyy: 消息");
        System.out.println("==================================");
    }
}
