package com.github.excellent01;

import java.util.Arrays;

/**
 * @auther plg
 * @date 2019/4/13 9:24
 */
enum Color{
    RED("red",1),BLUE("blue",2);
    private String name;
    private Integer id;
    private Color(String name,int id){
        this.name = name;
        this.id = id;
    }
}
@FunctionalInterface
interface A{
    void fun();
    default  void fun2(){

    }
}
interface B{
    int fun(int a,int b);
}
interface C{
    int fun(int c);
}
interface D<T>{
    T sum(T n);
}
public class TestEnum {
    public static void code1(){
        Person[] arr = new Person[3];
        arr[0] = new Person("Jack",18);
        arr[1] = new Person("Tom",20);
        arr[2] = new Person("Lucy",19);
        Arrays.sort(arr,(Person p1,Person p2) -> p1.age - p2.age);
        for(Person per : arr){
            System.out.println(per);
        }


    }
    public static void main(String[] args) {
        System.out.println( "heloo".valueOf("hehe"));
    }
}
class Person{
     String name;
     Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
