public class Test {
    public static void main(String[] args) {
        System.out.println(getThreeTimeChar("qywyery23tdd "));
    }

    /**
     * 1，给定一个英文字符串，请写一段代码找出这个字符串中首先出现三次的那个英文字符。
     * 2，
     * 输入： qywyery23tdd
     * 输出：　　y
     * *****************散列思想*******************8
     * @param str
     * @return
     */
    public static char getThreeTimeChar(String str){
        char[] data = str.toCharArray();
        int[] arr = new int[255];
        for(int i = 0; i < data.length; i++){
            char c = data[i];
            if(c <= 'z' && c >= 'a' || c <= 'Z' && c >= 'A'){
                arr[c]++;
                if(arr[c] == 3){
                    return c;
                }
            }
        }
        return '\u0000';
    }

}
