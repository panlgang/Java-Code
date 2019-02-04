package www.test.java;

/**
 * 出队 -- 头删
 * 入队 -- 尾插
 */
public class Queue {
    public Node head = new Node();
    class Node {
        Object obj;
        Node next;
    }
    public void inQueue(Object obj){
        Node newnode = new Node();
        newnode.obj = obj;
        newnode.next = head.next;
        head.next = newnode;
    }
    public void outQueue() {
        if(head.next == null){
            return;
        }
        if(head.next.next == null){
            head.next = null;
            return;
        }
        Node cur = head.next;
        Node del = head.next;
        while(cur.next != null){
            del = cur;
            cur = cur.next;
        }
        del.next = null;
    }
    public void printQueue(){
        Node cur = head.next;
        while(cur != null){
            System.out.print(cur.obj + "-->");
            cur = cur.next;
        }
        System.out.println("Over");
    }
}
