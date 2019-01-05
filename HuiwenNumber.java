public class HuiwenNumber {
    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++) {
            if(isHuiwneNumber(i)) {
                System.out.print(i+"、");
            }
        }
    }
    /**
     * 将数翻转，判断翻转前后的值是否相等，若相等则说明是回文数，否则则不是。
     * @param num  
     * @return
     */
    public static boolean isHuiwneNumber(int num) {
        int ret = num;
        int j = 0;
        while(num > 0) {
            j = j * 10 + num % 10;
            num /= 10;
        }
        return j == ret;
    }
}