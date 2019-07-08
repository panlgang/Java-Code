package Day27;

/**
 * @auther plg
 * @date 2019/7/8 18:52
 */
public class FirstsRepeatChar {
    public static void main(String[] args) {
        System.out.println(process("abaccdeff"));
    }
    public static char process(String str){
        if(str == null || str.length() == 0){
            throw new IllegalArgumentException("参数非法");
        }
        byte[] arr = new byte[256];
        int index = 0;
        for(int i = 0; i < str.length(); i++){
            index = str.charAt(i) - 'a';
            arr[index]++;
        }
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == i){
                return (char) (i + 'a');
            }
        }
       return '\u0000';
    }

}
