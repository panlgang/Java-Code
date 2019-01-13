import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for(int i = 10000; i <= 999999; i++){
            int sum = 0;
            int s= 0;
            int num = i;
            while(num > 0){
                s += num % 10;
                sum = sum * 10 + num % 10;
                num /= 10;
            }
            if(sum == i && s == n){
                System.out.println(sum);
            }
        }
    }
}
