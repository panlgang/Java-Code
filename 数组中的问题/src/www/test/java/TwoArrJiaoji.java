package www.test.java;

import java.util.*;

/**
 * 求两个数组的交集
 * @auther plg
 * @date 2019/4/7 22:07
 */
public class TwoArrJiaoji {
    public static void main(String[] args){
        int[] arr1 = new int[]{1,2,3,2,1};
        int[] arr2 = new int[]{2,1,4,5,6};
        List<Integer> list = fun(arr1,arr2);
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    public static List<Integer> fun(int[] arr1,int[] arr2){
        if(arr1 == null || arr2 == null || arr1.length == 0 || arr2.length == 0){
            return new ArrayList<Integer>();
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i = 0; i < arr2.length; i++){
            if(set.contains(arr2[i])){
                list.add(arr2[i]);
            }
        }
        return list;
    }
}
