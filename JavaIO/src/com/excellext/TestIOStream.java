package com.excellext.github;

import java.io.*;

/**
 * @auther plg
 * @date 2019/4/1 15:46
 */
public class TestIOStream {
    public static void main(String[] args) {
        //D:\Test
        String path = "D:" + File.separator + "Test" + File.separator + "竹子.jpg";
        try(OutputStream out = new FileOutputStream(path);
            InputStream in = new FileInputStream(path)){
            out.write("潘立刚".getBytes());
            int b = in.read();
            while(b != -1){
                System.out.print((char) b + " ");
                b = in.read();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
