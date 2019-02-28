package www.test;

public class Test {
    public static void main(String[] args) {
        SequenceBaseArray se = new SequenceBaseArray(2);
        se.add(1);
        se.add(2);
        se.add("hello");
        se.add(3);
        se.add(null);
        se.printArr();
       // se.delete(0);
        se.printArr();
    }

}
