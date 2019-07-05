package Day23;

/**
 * 剑指offer 10： 二进制中1 的个数
 * @auther plg
 * @date 2019/7/2 16:34
 */
public class NumberOf1 {
    public static int numberOf1(int num){
        int flag = 1;
        int count = 0;
        while(flag !=0){
            if((num & flag) != 0){
           // num & flag == 1   写法错误
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }
    public static int numOf1(int num){
        int count = 0;
        while(num != 0){
            num &= (num - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(-1));
        System.out.println(numOf1(-1));
    }
}
