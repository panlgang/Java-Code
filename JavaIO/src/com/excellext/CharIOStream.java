package com.excellext.github;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

/**
 * @auther plg
 * @date 2019/4/1 16:46
 */
public class CharIOStream {
    public static void main(String[] args) {
        File file = new File("E:\\JAVA代码\\javaProject\\JavaIO\\src\\com\\excellext\\github\\hello.txt");
        try(Writer in = new FileWriter(file,true)){
            in.append("heuchdbcewHJUPBCbybbcdvsV");
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
