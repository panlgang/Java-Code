import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,17,2,6,3,14};
        findSum_2(arr,20);
    }
    public static void findSum_1(int[] arr,int sum){
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] + arr[j] == sum){
                    System.out.println(arr[i] + "," + arr[j]);
                }
            }
        }
    }
    public static void findSum_2(int[] arr,int sum){
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            if(arr[i] + arr[j] == sum){
                System.out.println(arr[i] + "," + arr[j]);
                i++;
                j--;
            }else if(arr[i] + arr[j] < sum){
                i++;
            }else{
                j--;
            }
        }
    }
}
