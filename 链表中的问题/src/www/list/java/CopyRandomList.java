package www.list.java;
//复制含有random指针的链表
public class CopyRandomList {
    public Node copyRandomList(Node head){
        if(head == null){
            return head;
        }
        Node cur = head;
        Node next = null;
        //copy and link to end
        while(cur != null){
            next = cur.next;
            Node newNode = new Node(cur.val,null,null);
            newNode.next = next;
            cur.next = newNode;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        // set random
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        // split
        cur = head;
        Node ret = head.next;
        while(cur != null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = curCopy.next != null ? curCopy.next.next : null;
            cur = next;
        }
        return ret;

    }
}
