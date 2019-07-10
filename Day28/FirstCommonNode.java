package Day28;

/**
 * @auther plg
 * @date 2019/7/10 21:59
 */
class Node{
    Node next;
    int data;
}
public class FirstCommonNode {
    public static Node firstCommonNode(Node head1,Node head2){
        if(head1 == null || head2 == null){
            return null;
        }
        Node p1 = head1;
        Node p2 = head2;
        // 绝对相遇，可能为null。
        while(p1 != p2){
            p1 = p1.next == null ? p1.next : head2;
            p2 = p2.next == null ? p2.next : head1;
        }
        return p1;
    }
}
