package www.test.java;

public class StackList {
    public Node head = new Node();
    class Node{
        Node next;
        Object data;
        int size;
    }
    public void pushStack(Object data){
        Node newnode = new Node();
        newnode.data = data;
        newnode.next = head.next;
        head.next = newnode;
        head.size++;
    }
    public Node popStack(){
        if(head.next == null){
            return null;
        }
        Node pop = head.next;
        head.next = pop.next;
        this.head.size --;
        return pop;
    }
    public Node getTop(){
        return head.next;
    }
}
