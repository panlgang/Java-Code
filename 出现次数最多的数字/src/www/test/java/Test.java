package www.test.java;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6,7,8,9,4,2,2,3,4,5,6,8,9,54,3,2,3,3,5,5,6,5,5,5,5,5,5,5};
        System.out.println(getMostTime(arr));
    }

    /**
     * 开辟一块空间，将原数组中数字出现的次数，保存在下标原元数字相同的地方。
     * @param arr
     * @return
     */
    public static int getMostTime(int[] arr){
        int max = 0;
        int[] help = new int[100];
        for(int i = 0; i < arr.length; i++){
            help[arr[i]]++;
        }
        for(int i = 0; i < help.length; i++){
            max = max > help[i] ? max : help[i];
        }
        int j = 0;
        for(j = 0; j < help.length; j++){
            if(max == help[j]){
                break;
            }
        }
        return j;
    }

}
