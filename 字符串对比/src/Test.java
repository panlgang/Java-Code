import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str1 = input.nextLine();
        String str2 = input.nextLine();
        int ret = stringContrast(str1,str2);
        System.out.println(ret);

    }
    public static int stringContrast(String str1, String str2){
        if(str1.length() != str1.length()){
            return 1;
        }
        if(str1.equals(str2)){
            return 2;
        }
        if(str1.equalsIgnoreCase(str2)){
            return 3;
        }
        return  4;
    }
}
