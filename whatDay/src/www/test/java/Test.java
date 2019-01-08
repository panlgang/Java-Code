package www.test.java;
import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        int select = 0;
       do{
           menu();
           Scanner input = new Scanner(System.in);
           System.out.println("请选择：");
           select = input.nextInt();
           if(select == 0){
               System.out.println("拜拜！！！");
               System.exit(-1);
           }
           System.out.println("输入年：");
           int y = input.nextInt();
           if(y < 1){
               System.out.println("输入非法！！！！重新输入：");
               continue;
           }
           System.out.println("输入月：");
           int m = input.nextInt();
           if(m < 1 || m > 12){
               System.out.println("输入非法！！！！重新输入：");
               continue;
           }
           System.out.println("输入日：");
           int d = input.nextInt();
           if(d < 1 || d > 31){
               System.out.println("输入非法！！！！重新输入：1" );
               continue;
           }
           int sum = getSum(y,m,d);
           print(sum);
       }while (select==1);

    }

    /**
     *
     * @param y 年份
     * @param m 月份
     * @param d 日
     * @return 总的天数
     * 假定 1年1月1日为星期一，结果也正是这样，统计总的天数，然后对7取模
     */
    public static int getSum(int y, int m, int d){
        int[] month = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};
        int[] year = new int[10000];
        int sum = 0;
        for(int i = 1; i < y; i++){
            if(i%4 == 0 && i%100 != 0 || i%400 == 0){
                year[i] = 366;
            }
            else{
                year[i] = 365;
            }
            sum += year[i];
        }
        if(y%4 == 0 && y%100 != 0 || y%400 == 0){
            month[2] = 29;
        }
        for(int i = 0; i < m; i++){
            sum += month[i];
        }
        return sum + d;
    }
    public static void print(int sum){
        int num = sum % 7;
        switch (num){
            case 0:{
                System.out.println("Sunday 星期日");
                break;
            }case 1:{
                System.out.println("Monday 星期一");
                break;
            }case 2:{
                System.out.println("Tuesday 星期二");
                break;
            }case 3:{
                System.out.println("wednesday 星期三");
                break;
            }case 4:{
                System.out.println("Thursday 星期四");
                break;
            }case 5:{
                System.out.println("Friday  星期五");
                break;
            }case 6:{
                System.out.println("Saturday 星期六");
                break;
            }

        }
    }
    public static void menu(){
        System.out.println("**************************");
        System.out.println("**********1.开始**********");
        System.out.println("**********0.退出**********");
        System.out.println("**************************");
    }
}
