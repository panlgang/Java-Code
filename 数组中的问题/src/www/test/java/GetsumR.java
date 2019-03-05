package www.test.java;

public class GetsumR {
    public static int getSumR(int[] arr){
        return getSumR(arr,arr.length - 1);
    }
    private static int getSumR(int[] arr,int l){
        if(l == 0){
            return arr[0];
        }
        return getSumR(arr,l-1) + arr[l];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,5,6,7};
        System.out.println(getSumR(arr));
    }
}
