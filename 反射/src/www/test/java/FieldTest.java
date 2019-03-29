package www.test.java;

import java.lang.reflect.Field;

/**
 * @auther plg
 * @date 2019/3/29 23:33
 */
public class FieldTest {
    public static void main(String[] args) {
      String str = "hello";
      Class cls = str.getClass();
        try {
            Field field = cls.getDeclaredField("value");
            field.setAccessible(true);
            field.set(str,"world");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
