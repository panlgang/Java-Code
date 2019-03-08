package www.list.java;

/**
 * 递归删除链表中的结点
 */
public class DeleteNodeR {
    public static ListNode deleteNodeR(ListNode head,int val){
        if(head == null){
            return head;
        }
        if(head.val == val){
            return deleteNodeR(head.next,val);
        }
        head.next = deleteNodeR(head.next,val);
        return head;
    }
}

