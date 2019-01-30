public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,2,2,3,3,3};
        System.out.println(fun(arr));
        for(int data : arr){
            System.out.print(data + " ");
        }
        //System.out.println(function(arr));
    }
    public static int fun(int[] arr){
        if(arr == null || arr.length== 0){
            return 0;
        }
        int s = 0;
        int f = 0;
        while(f < arr.length){
            if(arr[s] == arr[f]){
                f++;
            }else{
                s++;
                arr[s] = arr[f];
                f++;
            }
        }
        return s + 1;
    }
    public static int function(int[] arr){
        int i = 0;
        int count = 1;
        while(i < arr.length){
            if(i != arr.length - 1 && arr[i] != arr[i+1]){
                count++;
            }
            i++;
        }
        return count;
    }

}
