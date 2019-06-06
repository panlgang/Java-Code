package Day5;

/**
 * 在字符串中找没有重复的最长字串
 * @auther plg
 * @date 2019/5/24 23:20
 */
public class NoRepeatSubString {
    public static void main(String[] args) {
        System.out.println(fun("bbbbbb"));
        System.out.println(fun_2("bbbbbb"));
    }

    // 暴力解法
    public static String fun(String str){
        if(str == null || str.length() < 2){
            return str;
        }
        char[] arr = str.toCharArray();
        String help = "";
        String res = "";
        for(int i = 0; i < str.length(); i++){
            help = String.valueOf(arr[i]);
           for(int j = i+1; j < str.length(); j++){
               if(!help.contains(String.valueOf(arr[j]))){
                   help += arr[j];
               }else{
                   res = res.length() > help.length() ? res : help;
                   help = String.valueOf(arr[j]);
               }
           }
        }
        return res;
    }

    public static String fun_2(String str){
        if(str == null || str.length() < 2){
            return str;
        }
        char[] arr = str.toCharArray();
        String res = "";
        String ret = "";
        for(int i = 0; i < arr.length; i++){
            if(!res.contains(String.valueOf(arr[i]))){
                res += arr[i];
            }else{
                ret = ret.length() > res.length() ? ret : res;
                res = "";
            }
        }
        return ret;
    }
}
