package Day21;

/**
 * 剑指offer4 ： 替换空格
 * @auther plg
 * @date 2019/6/30 19:31
 */
public class ReplaceBlank {
    public static void main(String[] args) {
        String str = replaceBlank("We are Happy");
        System.out.println(str);
    }
    public static String replaceBlank(String str){
        if(str == null || str.length() == 0){
            return str;
        }
        String[] arr = str.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s : arr){
            sb.append(s + "20%");
        }
        return new String(sb.substring(0,sb.length() - 3));
    }
}
