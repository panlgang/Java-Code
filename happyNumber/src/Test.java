public class Test {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    /**
     * 快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和
     * 然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
     * 如果可以变为 1，那么这个数就是快乐数。
     * 注：非快乐数最后会循环变成89，然后出现死循环
     * @param num
     * @return
     */
    public static boolean isHappy(int num){
        int sum = 0;
        if(num <= 0){
            return false;
        }
        while(num > 0){
            sum += Math.pow(num%10,2);
            num /= 10;
        }
        if(sum == 1){
            return true;
        }
        if(sum == 89){
            return false;
        }
        return isHappy(sum);
    }
}
