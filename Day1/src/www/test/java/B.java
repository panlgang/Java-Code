package www.test.java;

public class B {
   static A a = new A();
   B (){
       System.out.println("B0");
       a.f();
   }
   B(int i){
       System.out.println("B1");
   }
}
