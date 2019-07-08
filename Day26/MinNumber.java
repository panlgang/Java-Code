package Day26;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 剑指offer33： 把数组排成最小的数
 * @auther plg
 * @date 2019/7/6 19:03
 */
class Compare implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return (o1 + o2).compareTo(o2 + o1);
    }
}
public class MinNumber {
    static Compare compare = new Compare();
    public static void main(String[] args) {
        String[] arr = new String[]{"3","321","32"};
        System.out.println(process(arr));
    }
    public static String process(String[] arr){
        if(arr == null || arr.length == 0){
            return 0 + "";
        }
        String ret = "";
        Arrays.sort(arr,compare);
        for(String s : arr){
            ret += s;
        }
        return ret;
    }

}
