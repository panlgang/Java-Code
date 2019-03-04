package www.list.java;

/**
 * 判断两个无环单链表是否相交
 */
public class IsIntersect {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode head1 = headA;
        ListNode head2 = headB;
        int lenA = 0;
        int lenB = 0;
        while(head1.next != null ){
            lenA++;
            head1 = head1.next;
        }
        while(head2.next != null){
            lenB++;
            head2 = head2.next;
        }
        if(head1 != head2){
            return null;
        }
        int count = Math.abs(lenA - lenB);
        ListNode fast = null;
        ListNode slow = null;
        if(lenA >= lenB){
            fast = headA;
            slow = headB;
        }else{
            fast = headB;
            slow = headA;
        }
        for(int i = 0; i < count; i++){
            fast = fast.next;
        }
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
