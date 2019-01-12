package www.test.java;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,324,556,90,78,67,89};
        //java.util.Arrays.sort(arr);
        bubble(arr);
        for(int data : arr){
            System.out.print(data + "、");
        }
    }
    public static void bubble(int[] arr){
                    for(int i = 0; i < arr.length-1; i++){
                        boolean flag = true;
                        for(int j = 0; j < arr.length - 1 - i; j++){
                            if(arr[j] > arr[j+1]){
                                arr[j] ^= arr[j+1];
                                arr[j+1] ^= arr[j];
                                arr[j] ^= arr[j+1];
                                flag = false;
                            }
                        }
                        if(flag ==true){  //内层for循环走完一遍后没有交换则说明已经有序。
                            return;
            }
        }
    }
}
