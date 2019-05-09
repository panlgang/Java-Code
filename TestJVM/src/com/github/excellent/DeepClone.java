package com.github.excellent;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther plg
 * @date 2019/5/9 16:03
 */
public class DeepClone implements Serializable {
    private String name;
    private List<String> Skills;
    private Integer age;

    public DeepClone(String name, List<String> skills, Integer age) {
        this.name = name;
        Skills = skills;
        this.age = age;
    }

    @Override
    public String toString() {
        return "DeepClone{" +
                "name='" + name + '\'' +
                ", Skills=" + Skills +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"C++","Java");
        DeepClone deepClone = new DeepClone("Tom",list,20);
        serializable(deepClone);
        DeepClone clone = unSerializable();
        System.out.println(clone == deepClone);
    }
    public static void serializable(DeepClone deepClone) {
        File file = new File("a.txt");
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))){
            out.writeObject(deepClone);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static DeepClone unSerializable(){
        File file = new File("a.txt");
        DeepClone deepClone = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))){
             deepClone = (DeepClone) in.readObject();
        }catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deepClone;
    }
}
