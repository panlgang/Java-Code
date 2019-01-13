package www.test.java;

public class Test {
    public static void main(String[] args) {
        for(int i = 100; i < 1000; i++){
            int num = i;
            int sum = 0;
            while(num > 0){
                sum += Math.pow(num % 10,3);
                num /= 10;
            }
            if(sum == i){
                System.out.print(sum + "、");
            }
        }
    }
}
