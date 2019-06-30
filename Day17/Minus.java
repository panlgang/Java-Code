package Day17;

/**
 * 位运算实现减法
 * @auther plg
 * @date 2019/6/5 12:31
 */
public class Minus {
    public static void main(String[] args) {
        System.out.println(minus(10,-2));
    }
    // 求num1 - num2;   == num1 + (-num2)   (-num2 == ~num + 1)
    public static int minus(int num1,int num2){
        num2 = add(~num2,1);
        return add(num1,num2);
    }

    private static int add(int num1,int num2){
        int sum = num1 ^ num2;
        int cin = (num1 & num2) << 1;
        while(cin != 0){
            int temp = sum;
            sum = sum ^ cin;
            cin = (temp & cin) << 1;
        }
        return sum;
    }
}
