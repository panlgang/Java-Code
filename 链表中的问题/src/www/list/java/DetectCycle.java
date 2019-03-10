package www.list.java;

public class DetectCycle {
    public static ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                break;
            }
        }
        if(fast == null || fast.next == null){
            return null;
        }
        //有环
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow =slow.next;
        }
        return slow;
    }
}
