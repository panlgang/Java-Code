package www.test.java;
public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,4,2};
        int smallsum = getSmallSum(arr);
        System.out.println(smallsum);
    }
        public static int getSmallSum(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length;i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] > arr[i]){
                    sum += arr[i];
                }
            }
        }
        return sum;
    }

}


//    public static int getSmallSum(int[] arr){
//        int sum = 0;
//        for(int i = 0; i < arr.length;i++){
//            for(int j = i + 1; j < arr.length; j++){
//                if(arr[j] > arr[i]){
//                    sum += arr[i];
//                }
//            }
//        }
//        return sum;
//    }