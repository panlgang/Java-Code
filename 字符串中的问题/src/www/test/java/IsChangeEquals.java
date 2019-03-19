package www.test.java;

import java.util.Arrays;

public class IsChangeEquals {
    //先排序再判断
    public static boolean permutation1(String str1,String str2){
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        str1 = new String(arr1);
        str2 = new String(arr2);
        return str1.equals(str2);
    }
    //利用辅助数组，统计每个字符出现的个数
    public static boolean permutation2(String str1,String str2){
       if(str1.length() != str2.length()){
           return false;
       }
       int[] arr = new int[256];
       for(int i = 0; i < str1.length(); i++){
           char val = str1.charAt(i);
           arr[val]++;
       }
       for(int i = 0; i < str2.length(); i++){
           char val = str2.charAt(i);
           if(--arr[val] < 0){   // 长度相同，因此可以这样判断无需遍历辅助数组。
               return false;
           }
       }
       return true;
    }

    public static void main(String[] args) {
        String str1 = "aabc";
        String str2 = "abc";
        System.out.println(permutation2(str1,str2));
        System.out.println(permutation1(str1,str2));

    }
}
