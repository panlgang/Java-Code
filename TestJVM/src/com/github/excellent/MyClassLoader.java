package com.github.excellent;

import java.io.*;
/**
 * @auther plg
 * @date 2019/5/7 17:33
 */
public class MyClassLoader extends ClassLoader {
    private String path;
    public MyClassLoader(String path){
        this.path = path;
    }
    @Override
    @Deprecated
    public Class<?> findClass(String name) {
        byte[] b = loadClassData(name);
        return super.defineClass(b,0,b.length);
    }

    private byte[] loadClassData(String name){
        name = path + ".class";
        try(InputStream in = new FileInputStream(name);ByteArrayOutputStream out = new ByteArrayOutputStream()){
            int len = 0;
            while((len = in.read()) != -1){
                out.write(len);
            }
            return out.toByteArray();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyClassLoader m = new MyClassLoader("C:\\Users\\Administrator.lenovo-PC\\Desktop\\Test");
        Class c = m.findClass("com.github.excellent.Test.class");
        System.out.println(c.getClassLoader());
        System.out.println(c.getClassLoader().getParent());
        c.newInstance();
    }

}

