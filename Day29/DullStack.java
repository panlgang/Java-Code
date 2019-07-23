package Day29;

import java.util.*;

/**
 * 单调栈结构的妙用
 * @auther plg
 * @date 2019/7/22 20:50
 */
public class DullStack {

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,1,5,6,2,7};
        int[][] ret = process(arr);
        for(int[] ar : ret){
            System.out.print("[");
            for(int i : ar){
                System.out.print(i + " ");
            }
            System.out.println("]");
        }
    }

    public static int[][] process(int[] arr){
        if(arr == null || arr.length == 0){
            return new int[][]{};
        }
        Stack<Integer> stack = new Stack<>();
        int[][] ret = new int[arr.length][2];
        for(int i = 0; i < arr.length; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int popIndex = stack.pop();
                int leftMin = stack.isEmpty() ? -1 : stack.peek();
                ret[popIndex][0] = leftMin;
                ret[popIndex][1] = i;
            }
            stack.push(i);
        }
        // 计算栈中剩余的位置
        while(!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftMin = stack.isEmpty() ? -1 : stack.peek();
            ret[popIndex][0] = leftMin;
            ret[popIndex][1] = -1;
        }
        return ret;
    }
}
