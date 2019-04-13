package com.github.excellent01;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

import static jdk.nashorn.internal.codegen.OptimisticTypesPersistence.load;

/**
 * @auther plg
 * @date 2019/4/13 16:57
 */


public class TestProperties {
    public static void main(String[] args) throws IOException {
        /**
         *  构造方法
         *  public Properties() {  this(null);}
         * public Properties(Properties defaults) { this.defaults = defaults; }
         */
        Properties ps = new Properties();
        /**
         * 存入一个（key,value）对
         */
        ps.setProperty("Tom","22");
        ps.setProperty("Jack","20");
        ps.setProperty("Lucy","17");
        ps.setProperty("null","17");
        ps.setProperty("Jack","26");
        /**
         * 根据key取出value，不存在则返回null。
         */
        System.out.println(ps.getProperty("Lucy"));
        System.out.println(ps.getProperty("lucy"));
        System.out.println(ps.getProperty("null","18"));
        ps.list(System.out);

        //Path parh = Paths.get("D\\","test.propertice");
        File file = new File("D:" + File.separator + "test.propertice");

        // 内部使用BufferedOutputStream,按行输出到文件
        // ps.store(new FileOutputStream(file),"add");
        // 将文件中的内容读出来
        Properties ps2 =  new Properties();
        ps2.load(new FileInputStream(file));
        ps2.list(System.out);
    }

}
