package com.excellent;
import com.BencherMark;
import com.Parameter;
import com.Test;
import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @auther plg
 * @date 2019/7/13 20:52
 */

public class Main {
    private static final int DEFAULT_GROUPS = 10;
    private static final int DEFAULT_TIMES = 100;
    private String packageName;
    private String packageDotName;

    public Main(String packageName, String packageDotName) {
        this.packageName = packageName;
        this.packageDotName = packageDotName;
    }

    public Main() {
    }

    public  List<String> getDirector() throws Exception {
        List<String> list = new ArrayList<String>();
        ClassLoader loader = Main.class.getClassLoader();
        Enumeration<URL> enums = loader.getResources(packageName);
        if(enums != null){
            while(enums.hasMoreElements()){
                URL url = enums.nextElement();
                String path = URLDecoder.decode(url.getPath(),"UTF-8");
                list.add(path);
            }
        }
        return list;
    }
    public  List<File> getClassFile(List<String> list){
        if(list == null || list.size() == 0){
            throw new IllegalArgumentException("非法的list !");
        }
        List<File> fileList = new ArrayList<File>();
        for(String path : list){
            File file = new File(path);
            if(file.isDirectory()){
                File[] files = file.listFiles();
                for(File file1 : files){
                    fileList.add(file1);
                }
            }
        }
        return fileList;
    }
    public  List<Test> isLeaglFile(List<File> list) throws Exception {
        List<Test> listObj = new ArrayList<Test>();
        if(list == null || list.size() == 0){
            throw new IllegalArgumentException("非法的list !");
        }
        for(File file : list){
            String name = file.getName();
            if(name.endsWith(".class")){
                String path = packageDotName + "." +  name.substring(0,name.length() - 6);
                Class<?> cls = Class.forName(path);
                if(Test.class.isAssignableFrom(cls)){
                    listObj.add((Test) cls.newInstance());
                }
            }
        }
        return listObj;
    }

    public  void test(List<Test> list) throws Exception {
        //System.out.println(list);
        int times = DEFAULT_TIMES;
        int groups = DEFAULT_GROUPS;
        for(Test test : list){
            Class<?> cls = test.getClass();
            Parameter annoClass = cls.getAnnotation(Parameter.class);
            // 获取类级别的属性
            if(annoClass != null){
                times = annoClass.times();
                groups = annoClass.groups();
            }
            Method[] methods = cls.getMethods();
            for(Method method : methods){
                // 判断方法是否为待测试方法
                if(method.isAnnotationPresent(BencherMark.class)){
                    // 获取方法级别的属性
                    Parameter annoMethod = method.getAnnotation(Parameter.class);
                    if(annoClass != null){
                        System.out.println("测试方法名称：" + method.getName());
                        System.out.println("====================");
                        times = annoClass.times();
                        groups = annoClass.groups();
                        for(int i = 0; i < groups; i++){
                            long start = System.nanoTime();
                            for(int j = 0; j < times; j++){
                                method.invoke(test);
                            }
                            long end = System.nanoTime();
                            System.out.println("第" + i + "组花费" + (end - start) + "纳秒");
                        }
                    }
                }

            }
        }
    }


    public static void main(String[] args) throws Exception {
        Main main = new Main("com/excellent","com.excellent");
        List<String> director =main.getDirector();
        List<File> classFile = main.getClassFile(director);
        List<Test> leaglFile = main.isLeaglFile(classFile);
        main.test(leaglFile);
    }

}
