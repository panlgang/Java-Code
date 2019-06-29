package Day15;

/**
 * @auther plg
 * @date 2019/6/4 14:05
 */
public class Test {
}
abstract class Animal{
    abstract void say();
}
class  Cat extends Animal{
    public Cat(){
        System.out.println("");
    }

    @Override
    void say() {

    }
    // 覆写抽象方法老哥
}
