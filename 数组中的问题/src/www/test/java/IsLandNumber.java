package www.test.java;

/**
 * @auther plg
 * @date 2019/4/2 18:22
 */
public class IsLandNumber {
    /**
     * 计算岛的数量
     * 二维数组中连续的1即是一个岛。
     * @param arr
     * @return
     */
    public static int countIsland(int[][] arr){
        if(arr == null || arr[0] == null){
            return 0;
        }
        int res = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 1){
                    res++;
                    // 感染函数
                    inflect(arr,i,j);
                }
            }
        }
        return res;
    }
    public static void inflect(int[][] arr,int i,int j){
        if(i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] != 1){
            return;
        }
        arr[i][j] = 2;
        inflect(arr,i+1,j);
        inflect(arr,i-1,j);
        inflect(arr,i,j+1);
        inflect(arr,i,j-1);
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0,0},{1,0,1,1,0},{1,0,0,0,1}};
        System.out.println(countIsland(arr));
    }
}
