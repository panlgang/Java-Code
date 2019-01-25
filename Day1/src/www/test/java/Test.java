package www.test.java;

public class Test {
    public static void main(String[] args) {
        for(Color c : Color.values()){
            System.out.println(c + " " + c.ordinal());
        }
    }

}
