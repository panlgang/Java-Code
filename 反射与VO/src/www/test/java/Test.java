package www.test.java;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther plg
 * @date 2019/3/30 11:30
 */
class Emp{
    private String name;
    private Integer age = 20;
    private String skill;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Emp(){}

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

    public Emp(String name, Integer age, String skill) {
        this.name = name;
        this.age = age;
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skill='" + skill + '\'' +
                '}';
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        String str = "name:Jack|skill:java,C++";
        Emp emp = new Emp("张三",20,"C#");
        System.out.println(emp);
        String[] arr = str.split("\\|");
        for(int i = 0; i < arr.length; i++){
            setValue(emp,arr[i]);
        }
        System.out.println(emp);
    }
    public static void setValue(Emp emp,String str) throws Exception {
        String[] arr = str.split(":");
        Class cls = emp.getClass();
        String setMethodName = getMethodName(arr[0]);
        Method setMethod = cls.getDeclaredMethod(setMethodName,arr[1].getClass());
        setMethod.invoke(emp,arr[1]);
    }
    public static String getMethodName(String str){
        return "set" + str.substring(0,1).toUpperCase() + (str.length() > 1 ? str.substring(1) : "");
    }
}
