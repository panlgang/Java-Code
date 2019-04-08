package com.test.collection;

import java.util.Objects;

/**
 * @auther plg
 * @date 2019/4/8 21:08
 */
public class Person implements Comparable<Person> {
    private String name;
    private Integer age;
    public Person(){}
    public Person(String name,Integer age){
        this.age = age;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
