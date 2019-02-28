package www.test.java;

public class Totalmount {
    public static void main(String[] args) {
        System.out.println(getTotal(1));
    }
    public static int getTotal(int day){
        if(day == 10){
            return 1;
        }
        return ((getTotal(day + 1)) + 1) * 2;
    }
}
