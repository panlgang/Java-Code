package www.test.java;

/**
 * 求最小公倍数
 */
public class CommonMultiple {
    public static void main(String[] args) {
        System.out.println(commonMultiple(2,5));
    }
    public static double commonMultiple(double a,double b){
        double i = 0;
        for(i = 1; i < a * b; i++){
            if(i % a == 0 && i % b == 0){
                break;
            }
        }
        return i;
    }
}
