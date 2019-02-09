package www.test.java;

public class Pythagorean {
    public static void main(String[] args) {
        pythagorean();
    }
    public static void pythagorean(){
        for(int a = 1; a < 1000; a++){
            for(int b = 1; b < 1000; b++) {
                for (int c = 1; c < 1000; c++) {
                    if (a * a + b * b == c * c && a < b && b < c &&fun(a,b,c)) {
                        System.out.println(a + "、" + b + "、" + c);
                    }
                }
            }
        }
    }
    public static boolean fun(int a,int b,int c){
        if(a + b > c){
            return true;
        }
        return false;
    }
}
