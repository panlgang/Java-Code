package Day7;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @auther plg
 * @date 2019/5/25 18:00
 */
public class Main1{
    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        list.add(in.nextInt());
        System.out.println(majorityElement(list));

    }
    public static  int majorityElement(ArrayList<Integer> list) {
        if(list == null || list.size() == 0){
            throw new RuntimeException("");
        }
        Integer num = list.get(0);
        int count = 1;
        for(int i = 1; i < list.size(); i++){
            if(num.equals(list.get(i))){
                count++;
            }else if(--count == 0){
                num = list.get(i);
                count = 1;
            }
        }
        return num;
    }
}