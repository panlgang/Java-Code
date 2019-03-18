package www.test.java;

public class Soluction1 {
    public static boolean isAllNotSame(String str){
        if(str == null || str.length() < 2){
            return true;
        }
        if(str.length() > 256){
            return false;
        }
        boolean[] flag = new boolean[256];
        for(int i = 0; i < str.length(); i++){
            char val = str.charAt(i);
            if(flag[val]){
                return false;
            }
            flag[val] = true;
        }
        return true;
    }

    public static void main(String[] args) {
//        String str = "hello";
//        System.out.println(isAllNotSame("helo"));
        char ch = 0;
        System.out.println(ch);
    }
}
