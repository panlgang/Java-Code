package Day30;

import java.util.Stack;

/**
 * @auther plg
 * @date 2019/7/23 15:16
 */
public class MaxRecSize {
    public static int maxRecSize(int[][] arr){
        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return 0;
        }
        int[] height = new int[arr[0].length];
        int maxRet = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                // 对数组该位置的值进行更新
                height[j] = arr[i][j] == 0 ? 0 : height[j] + 1;
            }
            maxRet = Math.max(maxRet,process(height));
        }
        return maxRet;
    }

    private static int process(int[] height) {
        if(height == null || height.length ==0){
            return 0;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() || height[i] <= stack.peek()){
                int popIndex = stack.pop();
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int curArea = (i - leftIndex - 1) * height[popIndex];
                maxArea = Math.max(maxArea,curArea);
            }
        }
        while(!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            int curArea = (height.length - leftIndex - 1) * height[popIndex];
            maxArea = Math.max(maxArea,curArea);
        }
        return maxArea;
    }
}
