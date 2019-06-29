package Day12;

/**
 * @auther plg
 * @date 2019/5/30 15:24
 */
public class TestSelect {
    public static void main(String[] args) {
        try{
            int b = 10 / 0;
        }catch (Exception e){
            System.out.println(1);
            throw new RuntimeException();   // 此处抛出了异常
        }finally {
            System.out.println(2);
        }
        System.out.println(3);    // 该处的代码得不到执行
    }
}
