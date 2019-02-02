package www.test.java;

/**
 *      （1）位数不得是2，3，5的倍数；
 * 　　（2）该数不能被2，3，5整除；
 * 　　（3）该数必须为整数。
 */
public class TestNothing {
    public static void main(String[] args) {
        System.out.println(function(-7));
    }
    public static boolean function(int num){
        int count = 1;
        int tmp = num;
        while(tmp > 9){
            tmp /= 10;
            count++;
        }
        if(num % 2 != 0 && num % 3 != 0 && num % 5 != 0){
            if(count % 2 != 0 && count % 3 != 0 && count % 5 != 0){
                return true;
            }
        }
        return false;
    }
}
