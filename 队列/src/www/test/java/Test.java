package www.test.java;

public class Test {
    public static void main(String[] args) {
        Queue q = new Queue();
        for(int i = 0; i < 5; i++){
            q.inQueue(i);
        }
        q.printQueue();
        q.outQueue();
        q.outQueue();
        q.outQueue();
        q.outQueue();
        q.outQueue();




        q.printQueue();

    }
}
