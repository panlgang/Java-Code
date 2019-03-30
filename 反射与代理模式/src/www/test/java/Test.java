package www.test.java;

import java.lang.reflect.Constructor;

/**
 * @auther plg
 * @date 2019/3/30 12:11
 */
interface ISubject{
    public void eat();
}
class ProxySubject implements ISubject{

    ISubject realSubject;
    public ProxySubject(ISubject realSubject){
        this.realSubject = realSubject;
    }
    private void preEat(){
        System.out.println("buy....");
    }
    private void aftEat(){
        System.out.println("wash...");
    }
    @Override
    public void eat() {
        preEat();
        realSubject.eat();
        aftEat();
    }
}
class RealSubject implements ISubject{

    @Override
    public void eat() {
        System.out.println("eatting...");
    }
}
class ObjectFactory{
    public static <T> T getInstance(String realClassName) throws Exception {
        T realSubject = null;
        Class<T> cls = (Class<T>) Class.forName(realClassName);
        realSubject = cls.newInstance();
        return realSubject;
    }

    // 只需要代理类和业务类的类的全名称，就可以搞定任何代理模式。
    public static<T> T getInstance(String realClassName,String proxyClassName) throws Exception {
        Class<T> cls1 = (Class<T>) Class.forName(proxyClassName);
        Class<T> cls2 = (Class<T>) Class.forName(realClassName);
        T realSubject = cls2.newInstance();
        T ret = null;
        Constructor con = cls1.getConstructor(cls1.getInterfaces()[0]);
        ret = (T) con.newInstance(realSubject);
        return ret;
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
//        ISubject realSubject = new RealSubject();
//        ISubject proxySubjett = new ProxySubject(realSubject);
//        proxySubjett.eat();
    ISubject subject = ObjectFactory.getInstance("www.test.java.RealSubject","www.test.java.ProxySubject");
    subject.eat();
    }
}
