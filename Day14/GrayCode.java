package Day14;

/**
 * 生成格雷码
 * 1 0        1
 * 2 00 01 11 10
 * 3 000 001 011 010  110 111 101 100
 * @auther plg
 * @date 2019/6/1 16:06
 */
public class GrayCode {
    public String[] getGray(int n) {
        String[] ret = null;
        if(n == 1){
            ret =  new String[]{"0","1"};
        }else{
            String[] strs = getGray(n - 1);
            ret = new String[2 * strs.length];
            for(int i = 0; i < strs.length;i++){
                ret[i] = "0" + strs[i];
                ret[ret.length -  1 - i] = "1" + strs[i];
            }
           "hello".split(" ");

        }
        return ret;
    }

}
