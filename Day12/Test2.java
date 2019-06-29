package Day12;

/**
 * @auther plg
 * @date 2019/5/30 15:27
 */
public class Test2 {
    public static void main(String[] args) {
        Object o = new Object(){
            @Override
            public boolean equals(Object obj) {
                return true;
            }
        };
        System.out.println(o.equals("read"));
    }

}
