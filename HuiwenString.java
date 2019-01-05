public class HuiwenString {
    public static void main(String[] args) {
        System.out.println(isHuiwenString("abcdcba"));
        System.out.println(isHuiwenString("abcdcuiba"));
        
    }
    /**
     * 回文字符串与大小写无关，因此先将字符串整体转为大写，然后再转化为数组，
     * 两个索引，一个从头开始，一个从尾开始，一一比较，若有不同则返回false
     * 若两个索引相遇且一直相等则返回true。
     * @param str
     * @return
     */
    public static boolean isHuiwenString(String str) {
        if(str == null || str.isEmpty()) {
            return true;
        }
        str.toUpperCase();
        char[] arr = str.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while(j > i) {
            if(arr[j] == arr[i]){
                j--;
                i++;
            }else {
                return false;
            }
        }
        return true;
    }
}