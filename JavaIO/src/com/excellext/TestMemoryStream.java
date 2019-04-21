package com.excellext.github;

import java.io.*;

/**
 * @auther plg
 * @date 2019/4/20 10:15
 */
public class TestMemoryStream {
    public static void main(String[] args) throws IOException {
         File file1 = new File("hell.txt");
         File file2 = new File("hello.txt");
         String str1 = read(file1);
         String str2 = read(file2);
        System.out.println(str1 + str2);
    }
    public static String read(File file){
        try(InputStream in = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();){
            byte[] buff = new byte[3];
            int len = -1;
            while((len = in.read(buff)) != -1){
                // 将文件内容读进来，存入内存中。
                bos.write(buff,0,len);
            }
            return new String(bos.toByteArray());
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
