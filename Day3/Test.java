package Day3;

/**
 * 最长数字子串
 * 很像最大连续子序列和
 * @auther plg
 * @date 2019/5/22 10:48
 */
public class Test {
    public String test(String str){
        if(str == null || str == ""){
            return "";
        }
        StringBuilder ret1 = new StringBuilder();
        StringBuilder ret3 = new StringBuilder();
        char[] arr = str.toCharArray();
        for(int i = 0;i < arr.length;i++){
            if(arr[i] <= '9' && arr[i] >= '0'){
                ret1.append(arr[i]);
            }else{
                ret3 = ret1.length() >= ret3.length() ? ret1 : ret3;  // 记录作用
                ret1 = new StringBuilder();
            }
        }
        return ret3.toString();
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println( test.test("12345abc345sc80902ib"));
    }
}
