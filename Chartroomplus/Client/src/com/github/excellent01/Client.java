package com.github.excellent01;

import java.io.IOException;
import java.net.Socket;

/**
 * @auther plg
 * @date 2019/5/10 23:47
 */
public class Client {
    public static void main(String[] args) {
        int defaultPort = 8090;
        String defaultHost = "127.0.0.1";
        int port = defaultPort;
        String host = defaultHost;
        //port="8080" host="127.0.0.1"
        for(String arg : args){
            if(arg.startsWith("port=")){
               try{
                   port = Integer.parseInt(arg.substring("port=".length()));
               }catch (NumberFormatException e){
                   port = defaultPort;
               }
            }
            if(arg.startsWith("host=")){
                host = arg.substring("host=".length());
                if(!hostIsLegal(host)){
                    host = defaultHost;
                }
            }
        }
        try {
            Socket socket = new Socket(host,port);
            new SendMessage(socket).start();
            new ReceiveMessage(socket).start();
        } catch (IOException e) {
            //TODO
            System.out.println("异常退出。。。。");
        }
    }

    private static boolean hostIsLegal(String host) {
       if(host == null)
        return true;
       String[] arr = host.split("\\.");
       if(arr.length != 4){
           return false;
       }
       for(String str : arr){
           try{
               int num = Integer.parseInt(str);
               if(num < 0 || num > 255){
                   return false;
               }
           }catch (NumberFormatException e){
               return false;
           }
       }
       if(host.endsWith("\\.")){
           return false;
       }
       return true;
    }
}
