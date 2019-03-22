package www.test.java;

/**
 * @auther plg
 * @date 2019/3/22 17:30
 * 字符串压缩
 * aabbcddeeggg  --- >   a2b2c1d2e2g3
 * 若压缩后的字符串长度大于或者等于原字符串，返回原字符串
 */
public class StringCompress {
    public static String stringCompress(String str){
        if(str == null){
            return str;
        }
        StringBuffer sb = new StringBuffer();
        char val = str.charAt(0);
        int count = 1;
        for(int i = 1; i < str.length(); i++){
            if(val == str.charAt(i)){
                count++;
            }else{
                sb.append(val).append(count);
                val = str.charAt(i);
                count = 1;
            }
        }
        sb.append(val).append(count);
        if(sb.length() > str.length()){
            return str;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aabbcddeeggg";
        String ret = stringCompress(str);
        System.out.println(ret);
    }
}
