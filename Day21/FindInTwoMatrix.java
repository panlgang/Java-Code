package Day21;

/**
 * 题目描述：剑指offer3 ： 二维数组中的查找
 * @auther plg
 * @date 2019/6/29 19:29
 */
public class FindInTwoMatrix {
    public static boolean isContain(int[][] arr,int key){
        if(arr == null || arr.length == 0){
            return false;
        }
        int r = 0;   // 行
        int l = arr[0].length - 1; // 列
        while(r < arr.length && l >= 0){
            if(arr[r][l] == key){
                return true;
            }
            if(arr[r][l] > key){
                l--;
            }else{
                r++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1,2,8,9},
                {2,4,9,10},
                {4,7,10,13},
                {6,8,11,15}
        };
        System.out.println(isContain(arr,10));
        System.out.println(isContain(arr,1));
        System.out.println(isContain(arr,3));
        System.out.println(isContain(arr,5));
    }
}
