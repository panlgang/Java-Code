package Day22;

/**
 * 剑指offer5： 逆序打印链表
 * @auther plg
 * @date 2019/6/30 19:37
 */
class Node{
    Node next;
    int data;
    Node(int data,Node next){
        this.data = data;
        this.next = next;
    }
}
public class PrintListReverse {
    public static void main(String[] args) {
        Node node3 = new Node(3,null);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);

        printListReverse(node1);
    }
    public static void printListReverse(Node head){
        if(head == null){
            return;
        }
        printListReverse(head.next);
        System.out.print(head.data + "-->");
    }
}
