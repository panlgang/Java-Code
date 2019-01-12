package www.test.java;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        long ret = convert(str);
        System.out.println(ret);

    }
    public static long convert(String str){
        char[] arr = str.toCharArray();
        long sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] >= 'A' && arr[i] <= 'F' )
            {
                sum += (arr[i] - 55) * Math.pow(16,arr.length - i - 1);
            }
            else if(arr[i] >= 'a' && arr[i] <= 'f')
            {
                sum += (arr[i] - 87) * Math.pow(16,arr.length - i - 1);
            }
            else
            {
                sum += (arr[i] - '0') * Math.pow(16,arr.length - i -1);
            }
        }
        return sum;
    }
}
