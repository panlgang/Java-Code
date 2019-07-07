package Day24;

/**
 * 剑指offer31： 数组中出现次数超过一半的数
 *  摩尔投票法
 * @auther plg
 * @date 2019/7/4 17:28
 */
public class MoreThanHalfNumber {
    public static int moreThanHalfNumber(int[] arr){
        if(arr == null || arr.length == 0){
            throw new IllegalArgumentException("参数不合法!");
        }
        int result = arr[0];
        int times = 1;
        for(int i = 1; i < arr.length; i++){
            if(result == arr[i]){
                times++;
            }else{
                times--;
            }
            if(times == 0){
                times = 1;
                result = arr[i];
            }
        }

        // 得到结果在检验一下
        if(check(arr,result)){
            return result;
        }
        throw new IllegalArgumentException("参数不合法!");
    }

    private static boolean check(int[] arr, int result) {
        int times = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == result){
                times++;
            }
        }
        return times > (arr.length / 2);
    }

    public static void main(String[] args) {
        System.out.println(moreThanHalfNumber(new int[]{1,2,2,2,3}));
    }
}
