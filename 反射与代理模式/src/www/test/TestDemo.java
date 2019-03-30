package www.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther plg
 * @date 2019/3/30 14:41
 * 反射与动态代理
 */
// 1.业务接口
interface Subject{
    public void action();
}
// 2. 真实业务类
class RealSubject implements Subject{

    @Override
    public void action() {
        System.out.println("我是真实业务类，记得执行我！");
    }
}
// 3.动态代理类
class ProxySubject implements InvocationHandler{

    Object object ;   // 真实业务类对象

    /**
     *
     * @param obj 真实业务类对象实例
     * @return  代理类实例
     */
    public Object bind(Object obj){
        this.object = obj;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //
        pre();
        Object ret = method.invoke(this.object,args);
        //
        after();
        return ret;
    }
    public void pre(){
        System.out.println("业务前");
    }
    public void after(){
        System.out.println("业务后");
    }
}
public class TestDemo {
    public static void main(String[] args) {
        Subject realSubject = (Subject) new RealSubject();
        ProxySubject proxySubject = new ProxySubject();
        Subject proxyObject = (Subject) proxySubject.bind(realSubject);
        proxyObject.action();
    }

}
