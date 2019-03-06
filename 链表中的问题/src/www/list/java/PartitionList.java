package www.list.java;

/**
 * 对链表进行partition操作
 * 思路，创建两个头节点，然后根据要求依次挂上结点，最后合并在一起即可。
 */
public class PartitionList {
    public ListNode partitionList(ListNode head,int val){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyNode1 = new ListNode(0);
        ListNode dummyNode2 = new ListNode(0);
        ListNode head1 = dummyNode1;
        ListNode head2 = dummyNode2;
        ListNode cur = head;
        while(cur != null){
            if(cur.val < val){
                head1.next = cur;
                head1 = head1.next;
            }else{
                head2.next = cur;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if(head1 != null){
            head1.next = dummyNode2.next;
            head2.next = null;  //  很重要，防止后面串着很多
            return dummyNode1.next;
        }
        // head1 == null;
        return dummyNode2.next;
    }
}
