package www.test.java;

/**
 * 寻找没有重复元素的最长字串
 * @auther plg
 * @date 2019/4/7 21:02
 */
public class SubStringWithoutRepeat {
    public static void main(String[] args) {
        String str = "ava";
        System.out.println(fun_1(str));
        System.out.println(fun_2(str));

    }

    /**
     * 暴力解法，O(n*n)
     * 拿出一个元素，向后遍历，满足条件时，加在后面，
     * 否则，统计当前最大长度，拿下一个元素
     * @param str
     * @return
     */
    public static int fun_1(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        int len = 0;
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++){
            String s = new String(String.valueOf(str.charAt(i)));
            for(int j = i+1; j < arr.length; j++){
               if(!s.contains(String.valueOf(arr[j]))){
                   s+=arr[j];
               }else{
                   len = Math.max(len,s.length());
                   break;
               }
            }

        }
        return len;
    }

    /**
     * 滑动窗口
     * @param str
     * @return
     */
    public static int fun_2(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        //  一个字符出现的频次
        char[] freq = new char[256];
        int ans = 0;
        int l = 0;
        int r = -1;
        while(l < str.length()){
            //后边字符的不在窗口内
            if(r+1 < str.length() && freq[str.charAt(r+1)] == 0){
                freq[str.charAt(++r)]++;
            }else{   // 左边去掉一个字符
                freq[str.charAt(l++)]--;
            }
            ans = Math.max(ans,r - l + 1);
        }
        return ans;
    }
}
