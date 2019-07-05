package Day23;

/**
 * 剑指offer 11  数值的整数次方
 * @auther plg
 * @date 2019/7/3 17:36
 */
public class Day24 {
    public static double myPower(double base,int e){
        if(e == 0){
            return 1;
        }
        if(e == 1){
            return base;
        }
        int temp = e;
        e = e > 0 ? e : -e;
        double result = myPower(base,e >> 1);
        result *= result;
        if((temp & 0x1) == 1){   // 奇数
            result =  base * result;
        }
        if(temp < 0){
            return 1 / result;
        }else{
           return result;
        }

    }

    public static void main(String[] args) {
        System.out.println(myPower(2,-2));
        System.out.println(Math.pow(2,-2));
    }
}
