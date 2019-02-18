package www.test.java;

public class Queue {
    QNode head = new QNode();
    int size = 0;
    private class QNode {
        BST.Node node;
        QNode next;
    }
    public void inQueue(BST.Node node){
        QNode newNode = new QNode();
        newNode.node = node;
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }

    public BST.Node outQueue(){
        if(head.next == null ){
           throw new RuntimeException("head.next == null");
        }
        if(head.next.next == null){   // 当仅有一个结点的时候
            BST.Node ret = head.next.node;
            head.next = null;
            size--;
            return ret;

        } else {
            QNode cur = head.next;
            QNode prev = head.next;
            while(cur.next!= null){
                prev = cur;
                cur = cur.next;
            }
            BST.Node ret = cur.node;
            prev.next = null;
            size--;
            return ret;
        }
    }
    public boolean isEmpty(){
        return size == 0;
    }
}

//public class Queue {
//    public Node head = new Node();
//    class Node {
//        Object obj;
//        Node next;
//    }
//    public void inQueue(Object obj){
//        Node newnode = new Node();
//        newnode.obj = obj;
//        newnode.next = head.next;
//        head.next = newnode;
//    }
//    public Node outQueue() {
//        if (head.next == null) {
//            return null;
//        }
//        Node tmp = head.next;
//        while(head.next.next == null){
//            head.next = null;
//            return tmp;
//        }
//        Node cur = head.next;
//        Node prev = head.next;
//        while(cur.next != null){
//            prev = cur;
//            cur = cur.next;
//        }
//        Node ret = cur;
//        prev.next = null;
//        return ret;
//    }
//    public int getLength(){
//        int len = 0;
//        Node cur = head.next;
//        while(cur != null){
//            len++;
//            cur = cur.next;
//        }
//        return len;
//    }
//}
