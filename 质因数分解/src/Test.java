public class Test {
    public static void main(String[] args) {
        for(int i = 3; i <= 10;i++) {
            fun(i);
        }
    }
    /**
     * 分解质因数
     *
     * @param n
     * n % 2 != 0 则它的因数%2也不为0.因此没有再%2的必要
     *
     * 28  2
     * 14  2
     * 7   7
     */
    public static void fun(int n){
        System.out.print(n + "=");
        int i = 2;
        while(i < n){
            if(n % i == 0){
                System.out.print(i + "*") ;
                n /= i;
            }else {
                i++;
            }
        }
        System.out.println(n);
    }

}


