import java.math.BigDecimal;
import java.util.Scanner;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.nextLine();
        String str2 = input.nextLine();
        int[] add = bigAdd(str1,str2);
        for(int i = add.length - 1 ; i >= 0; i--){
           if(i == add.length - 1 && add[add.length -1] == 0){
               continue;
           }
            System.out.print(add[i]);
        }
    }
    public static int[] bigAdd(String str1,String str2){
        if(str1 != null || str2 != null) {
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            int i = 0;
            int j = 0;
            int less = arr1.length < arr2.length ? arr1.length : arr2.length;
            int more = arr1.length > arr2.length ? arr1.length : arr2.length;
            int len = arr1.length > arr2.length ? arr1.length + 1 : arr2.length + 1;
            char[] arr4 = arr1.length > arr2.length ? arr1 : arr2;
            int[] arr3 = new int[len];
            int r = 0;
            for(i = 0; i < less; i++){
                arr3[i] = (( arr1[i] + arr2[i] - 96) + r) % 10;
                r = (arr1[i] + arr2[i] - 96) / 10;
            }
            for(j = i; j < more; j++){
                arr3[j] = (arr4[j] - 48 + r) % 10;
                r = (arr4[j] - 48 + r) / 10;
            }
            arr3[more] = r;
            return arr3;
        }
            return null;
    }

}
