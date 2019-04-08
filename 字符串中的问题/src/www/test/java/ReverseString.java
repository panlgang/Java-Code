package www.test.java;

/**
 * @auther plg
 * @date 2019/4/8 22:15
 */
public class ReverseString {
    public void reverseString(char[] s) {
        if(s == null || s.length <= 1){
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while(left < right){
           if(s[left] != s[right]){
               char val = s[left];
               s[left] = s[right];
               s[right] = val;
           }
           left++; right--;
        }
    }
}
