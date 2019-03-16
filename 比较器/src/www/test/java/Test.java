package www.test.java;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Student[] arr = new Student[3];
        arr[0] = new Student("A",23,12);
        arr[1] = new Student("C",26,17);
        arr[2] = new Student("B",20,19);
        Arrays.sort(arr,new CompareAge());
        for(Student stu : arr){
            System.out.println(stu);
        }
        System.out.println("**************************************");
        Arrays.sort(arr,new CompareId());
        for(Student stu : arr){
            System.out.println(stu);
        }
    }
}
