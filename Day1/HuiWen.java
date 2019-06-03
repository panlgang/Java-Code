package Day1;

/**
 * 水题
 * @auther plg
 * @date 2019/5/21 14:26
 */
public class HuiWen {
    public static void main(String[] args) {
        System.out.println(count("aba","bb"));
    }
    public static int count(String str1,String str2){
        int count = 0;
        if(str1 == null || str1 == ""){
            if(isHuiWen(str2)){
                return 1;
            }else{
                return 0;
            }
        }
        if(str2 == null || str2 == ""){
            if(isHuiWen(str1)){
                return 1;
            }else{
                return 0;
            }
        }

        for(int i = 0; i <= str1.length(); i++){
            StringBuilder sb1 = new StringBuilder(str1);
            StringBuilder sb2 = new StringBuilder(str2);
            System.out.println(String.valueOf(sb1.insert(i,sb2)));
           if(isHuiWen(String.valueOf(sb1.insert(i,sb2)))){
               count++;
           }
        }
        return count;
    }
    public static boolean isHuiWen(String str){
        StringBuilder sb = new StringBuilder(str);
        sb = sb.reverse();
        if(str.equals(String.valueOf(sb))){
            return true;
        }
        return false;
    }
}
