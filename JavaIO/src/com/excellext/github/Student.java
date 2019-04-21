package com.excellext.github;

import java.io.*;

/**
 * @auther plg
 * @date 2019/4/21 18:21
 */
//  实现Serializable接口
public class Student implements Serializable  {
    private String name;
    private transient Integer age;
    private static  String work = "student";
    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:" + this.name + "   " + "age:" + this.age + "   " + "work:" + this.work;
    }

    public static void main(String[] args) {
        Student stu = new Student("Jack",15);
        String path = "student.txt";
        File fIle = new File(path);
        serializable(fIle,stu);
        Student sturet = UnSerializable(fIle);
        System.out.println(sturet);
        System.out.println(stu == sturet);

    }
    public static void serializable(File fIle,Student stu){
        try( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fIle));){
            oos.writeObject(stu);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static Student UnSerializable(File file){
        Student stu = null;
       try( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));){
            stu = (Student) ois.readObject();
       }catch(IOException e){
           e.printStackTrace();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       }
       return stu;
    }
}
