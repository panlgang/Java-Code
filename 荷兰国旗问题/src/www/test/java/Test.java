package www.test.java;

/**
 * 指定一个数组，和一个数，将小于这个数的元素放这个数左边，
 * 等于这个数的放中间，
 * 大于这个数的元素放这个数的右边
 * 时间负责度O（N），空间复杂度O（1）
 */
public class Test {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,5,6,5,5,4,3,9,0,7,5};
        flag(arr,0,arr.length - 1,5);
        for(int data : arr){
            System.out.print(data + " ");
        }
        System.out.println();
    }
    public static void flag(int[] arr,int L,int R, int num){
        int less = L - 1;
        int more = R + 1;
        while(L < more){
            if(arr[L] < num){
                swap(arr,++less,L++);   //将当前数与小于区的前一个数进行交换，然后判断洗一个数
            }
            else if(arr[L] > num){      //将当前数与大于区的前一个数进行交换，接着判断交换过来的数
                swap(arr,--more,L);
            }
            else{         //直接判断下一个数
                L++;
            }
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
