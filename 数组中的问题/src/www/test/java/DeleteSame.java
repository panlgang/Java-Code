package www.test.java;

/**
 * 数组去重，返回长度即可
 * @auther plg
 * @date 2019/5/11 21:31
 */
public class DeleteSame {
    public static int deleteSame(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        int len = arr.length - 1;
        for(int i = 0; i <= len; i++){
            int j = i + 1;
            while(j <= len){
                if(arr[i] == arr[j]){
                    swap(arr,j,len--);
                }else{
                    j++;
                }
            }
        }
        return len + 1 ;
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,4,6,2,3,4,6,7,2,3,7,0,0,1};
        int len = deleteSame(arr);
        for(int i = 0; i < len; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
