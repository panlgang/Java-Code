package www.test;

/**
 * @auther plg
 * @date 2019/4/8 22:53
 */
public class Is2Pow {
    public boolean isPowerOfTwo(int n) {
       return n >0 && (n & (n - 1)) == 0;
    }
}
