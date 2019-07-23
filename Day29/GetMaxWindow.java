package Day29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 生成窗口最大值数组
 * 时间复杂度O（n * k）
 * @auther plg
 * @date 2019/7/22 18:32
 */
public class GetMaxWindow {
    public static List<Integer> getMaxWindow(int[] arr,int w){
        if(arr == null || arr.length == 0){
            return Collections.emptyList();
        }
        List<Integer>  list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            int max = arr[i];
            int j = i;
            for(; j < i + w && j < arr.length ; j++){
                max = max > arr[j] ? max : arr[j];
            }
            if(j == i + w)
            list.add(max);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5,4,3,3,6,7};
        List<Integer> list = getMaxWindow(arr,3);
        System.out.println(list);
    }
}
