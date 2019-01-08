import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("输入球的数量：");
        int m = input.nextInt();
        tobinary(m);
    }

    /**
     * 把m 个球放入编号为0，1，2，…，k-1 的k 个盒中(m<2^k)要求第i 个盒内必须放2^i只
     * 球。如果无法满足这一条件，就一个不放，求出放球的具体方案。
     * 例 ： 29个球化为二进制数是11101
     * 第0号盒放1只球，1号盒不放，2号盒放4只球，3号盒放8只球，4 号盒放16只球。
     *@param num
     */
    public static void tobinary(int num){
        int i = 0;
        int tmp = num;
        while(tmp > 0){
            tmp -= Math.pow(2,i);//统计该数化为二进制后的位数
            i++;
        }
        for(int j = i-1; j >= 0; j--){
            System.out.print(((num >> j) & 1) + "、");
       }
    }




}
