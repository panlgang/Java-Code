package com.excellext.github;

import java.io.*;

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
        File file = new File("D:" + File.separator + "Test" + File.separator + "Callable转换.png");
        InputStream in = null;
        try {
             in = new FileInputStream(file);
             byte[] buff = new byte[1024];
             int len = -1;
             while((len = in.read(buff)) != -1){
                 //in.flush();
                 System.out.println(new String(buff));
             }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
//            System.out.println(printLevel(level)+ file.getName());
            file.delete();

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
