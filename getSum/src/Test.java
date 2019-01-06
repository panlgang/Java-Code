public class Test {
    public static void main(String[] args){
        System.out.println(getSum(4,3));
    }
    public static double getSum(int x, int i){
            double sum = 0;
            for(int j = 0; j <= i; j++){
                sum += (power(x,j)/factorial(j));
            }
            return sum;
    }
    public static double factorial(int i){
        if(i <= 1){
            return 1;
        }
        return i * factorial(i-1);
    }
    public static double power(int x, int i){
        if(i == 0){
            return 1;
        }
        if(i == 1){
            return x;
        }
        for(int j = 2; j <= i; j++){
            x *= x;
        }
        return x;
    }
}
