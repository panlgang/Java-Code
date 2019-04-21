package com.excellext.github;

import java.io.File;
import java.io.IOException;

/**
 * @auther plg
 * @date 2019/4/17 19:00
 */
public class TestIO {
    public static void main(String[] args) {
       String path = "C:";
       File file = new File(path);
       File[] files = file.listFiles();
       for(File file1 : files){
           System.out.println(file1.getAbsolutePath());
       }
        System.out.println(file);

    }
}
