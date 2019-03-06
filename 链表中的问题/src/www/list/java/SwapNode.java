package www.list.java;
/*8

 */
public class SwapNode {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        head = dummyHead;
        while(head.next != null && head.next.next != null){
            ListNode node1 = head.next;
            ListNode node2 = node1.next;
            ListNode next = node2.next;
            node2.next = node1;
            node1.next = next;
            head.next = node2;
            head = node1;
        }
        ListNode retNode = dummyHead.next;
        dummyHead = null;
        return dummyHead;
    }
}
