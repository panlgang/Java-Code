package com.excellext.github;

import java.io.*;

/**
 * @auther plg
 * @date 2019/4/20 10:26
 */
public class TestPrintStream {
    private OutputStream out;
    public TestPrintStream(OutputStream out){
        this.out = out;
    }
    // 核心方法，任何类型都可以转换为String类型，都可以借助该方法输出
    public void print(String str){
        try {
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printInt(int data){
        this.print(String.valueOf(data));
    }
    public void printInt(double data){
        this.print(String.valueOf(data));
    }
    // .......
    public static void main(String[] args) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new File("hell.txt"));

    }
}
