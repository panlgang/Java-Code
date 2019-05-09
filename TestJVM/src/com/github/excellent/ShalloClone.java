package com.github.excellent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @auther plg
 * @date 2019/5/9 15:24
 */
public class ShalloClone implements Cloneable {
    private String name;
    private Integer age;
    private List<String> skills;
    private Object object;

    public ShalloClone(String name, Integer age, List<String> skills) {
        this.name = name;
        this.age = age;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public ShalloClone clone() {
        ShalloClone clone = null;
        try {
            clone = (ShalloClone) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShalloClone that = (ShalloClone) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(age, that.age) &&
                Objects.equals(skills, that.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, skills);
    }

    @Override
    public String toString() {
        return "ShalloClone{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skills=" + skills +
                ", object=" + object +
                '}';
    }

    public static void main(String[] args) {
       List<String> list = new ArrayList<>();
       Collections.addAll(list,"Java","C++");
       list.add("MySql");
       ShalloClone shalloClone = new ShalloClone("Tom",22,list);

       shalloClone.setObject("hehe");
       ShalloClone clone = shalloClone.clone();
       System.out.println(shalloClone == clone);
       System.out.println(shalloClone);
       System.out.println(clone);

       shalloClone.setName("Jack");
       System.out.println(shalloClone.getName());
       System.out.println(clone.getName());

       shalloClone.setAge(shalloClone.getAge() + 10);
       System.out.println(shalloClone.getAge());
       System.out.println(clone.getAge());

       shalloClone.setObject(new String("行号"));
       System.out.println(shalloClone.getObject());
       System.out.println(clone.getObject());
    }
    // 对于8大基本类型及String类
}
