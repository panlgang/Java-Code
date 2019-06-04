package Day4;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 水题
 * 在字符串str1中，删除字符串ztr2的包含的字符
 * @auther plg
 * @date 2019/5/23 11:56
 */
public class Main{
    public static void main(String[] args){
//        System.out.println(delete("abcde","abc"));
        int x = 5 >> 2;
        int a = 5 << 1;
        System.out.println(a);
        System.out.println(x);
        int y = x >>> 2;
        System.out.println( y);

    }
    public static String delete(String str1,String str2){
        if(str1 == null || str1 == "" || str2 == null || str2 == ""){
            return "";
        }
        StringBuilder ret = new StringBuilder("");
        char[] arr = str1.toCharArray();
        for(int i = 0; i < arr.length; i++){
            if(!contain(str2,arr[i])){
                ret.append(arr[i]);
            }
        }
        return ret.toString();
    }
    public static boolean contain(String str1,char ch){
        String help = String.valueOf(ch);
        return str1.contains(help);
    }
}
