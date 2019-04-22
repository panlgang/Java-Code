package com.excellext.github;

import sun.nio.cs.StreamEncoder;

import java.io.*;

/**
 * @auther plg
 * @date 2019/4/20 9:42
 */
public class TestConvertStream {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        try(InputStream input = new FileInputStream(file);
            Reader in = new InputStreamReader(input)){  // 字节流转换为字符流
            int len = -1;
            byte[] buff2 = new byte[3];
            System.out.print("字节流读入：");
            while((len = input.read(buff2))!= -1){
                System.out.print( new String(buff2,0,len));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
//    char[] buff1 = new char[3];
//            System.out.print("字符流读入：");
//                    while((len = in.read(buff1)) != -1){
//                    System.out.print(new String(buff1,0,len));
//                    }
//                    System.out.println();
