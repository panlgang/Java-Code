package www.test.java;

public class Power {
    public static void main(String[] args) {
        System.out.println(power(3,4));

    }

    /**
     * 求n ^ m;
     * @param n
     * @param m
     * @return
     */
    public static long power(long n,long m){
        if(m == 0){
            return 1;
        }
        if(m % 2 == 1){
            return power(n,m / 2) * power(n,m / 2) * n;
        }else {
            return power(n,m / 2)* power(n,m / 2);
        }

    }
}
