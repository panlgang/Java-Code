package www.test.java;

import java.util.Scanner;

public class ExactDiiv {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int min = input.nextInt();
        int max = input.nextInt();
        int factor = input.nextInt();
        for(int i = min; i <= max; i++){
            if(i % factor == 0){
                System.out.print(i + "、");
            }
        }
    }

}
