package com.excellext.github;

import java.io.File;
import java.io.IOException;

/**
 * File文件操作类
 * @auther plg
 * @date 2019/3/31 20:56
 */
public class TestFile {
    public static void code1(){
        String pathName = "D:" + File.separator + "Test" + File.separator + "Test.java";
        String path = "D:" + File.separator + "Test";
        File file = new File(path,"Test.txt");
        try {
            boolean rs = file.createNewFile();
            if(!rs){
                System.out.println("failed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //F:\c语言教程
        String pathName = "C:";
        File file = new File(pathName);
        listAll(file,0);
    }
    public static void deleteOrCreate(String pathName){
        if(pathName == null || pathName.length() == 0){
            throw new IllegalArgumentException("pathName is Illegal");
        }
        File file = new File(pathName);
        if(file.exists()){
            file.delete();
        }else{
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public static void deeOrCreat(String pathName){
        if(pathName == null || pathName.length() == 0){
            throw new IllegalArgumentException("pathName is illegal");
        }
        File file = new File(pathName);
        if(!file.getParentFile().exists()){
           boolean rs = file.mkdirs();
        }
        if(file.exists()){
            file.delete();
        }else{
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    // 递归打印目录
    public static void listAll(File file,int level) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if(files != null) {
                for (File f : files) {
                    listAll(f,level+1);
                }
            }
        }else{
            System.out.println(printLevel(level)+ file.getName());

        }
    }

    private static String printLevel(int level){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < level; i++){
            sb.append("-");
        }
        return sb.toString();
    }
}
