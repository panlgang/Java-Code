package www.list.java;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumber(ListNode head1,ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;

        ListNode dummyHead = new ListNode(-1);
        ListNode cur3 = dummyHead;
        int cin = 0;   // 进位
        int val = 0;   // 值
        while(cur1 != null && cur2 != null){
            val = (cur1.val + cur2.val + cin) % 10 ;
            cin = (cur1.val + cur2.val + cin) / 10 ;
            cur3.next = new ListNode(val);
            cur3 = cur3.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while(cur1 == null && cur2 != null){
            val = (cur2.val + cin) % 10;
            cin = (cur2.val + cin) / 10;
            cur3.next = new ListNode(val);
            cur2 = cur2.next;
            cur3 = cur3.next;
        }
        while(cur2 == null && cur1 != null){
            val = (cur1.val + cin) % 10;
            cin = (cur1.val + cin) / 10;
            cur3.next = new ListNode(val);
            cur1 = cur2.next;
            cur3 = cur3.next;
        }
        // 细节最高为有进位
        if(cur1 == null && cur2 == null && cin >= 1){
            cur3.next = new ListNode(cin);
        }
        return dummyHead.next;
    }


    // 递归实现
    public static ListNode addTwoNumber2(ListNode head1,ListNode head2){

        return addTwoNumber2R(head1,head2,0);
    }
    private static ListNode addTwoNumber2R(ListNode head1,ListNode head2,int cin){
        if(head1 == null && head2 == null && cin == 0){
            return null;
        }
        int val = cin;
        if(head1 != null){
            val += head1.val;
        }
        if(head2 != null){
            val += head2.val;
        }
        ListNode retNode = new ListNode(val % 10);
        ListNode more = addTwoNumber2R(head1 == null ? null : head1.next,head2 == null ? null : head2.next,val >= 10 ? 1 : 0);
        retNode.next = more;
        return retNode;

    }
}
