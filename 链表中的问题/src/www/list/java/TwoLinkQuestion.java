package www.list.java;

public class TwoLinkQuestion {
    public static ListNode twoLinkQuestion(ListNode head1,ListNode head2){
        if(head1 == null || head2 == null){
            return null;
        }
        ListNode loop1 = isCircle(head1);
        ListNode loop2 = isCircle(head2);
        //
        if(loop1 == null && loop2 == null){
            // 无环单链表的相交问题
            return noLoop(head1,head2,null);
        }
        if(loop1 != null && loop2 != null){
            //都有环
            if(loop1 != loop2) {
                //  66 结构，和  耳朵结构
                return bothLoop(head1, head2);
            }
            return noLoop(head1,head2,loop1);

        }
        //一个无环，一个有环
        return null;
    }
    public static ListNode noLoop(ListNode head1,ListNode head2,ListNode loop){
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        while(cur1 != cur2){
            cur1 = cur1 == loop ? head2 : cur1.next;
            cur2 = cur2 == loop ? head1 : cur2.next;
        }
        return cur1 != loop ? cur1 : null;
    }
    public static ListNode bothLoop(ListNode head1,ListNode head2){
        ListNode loop1 = isCircle(head1);
        ListNode loop2 = isCircle(head2);
        if(loop1 == loop2){
            return noLoop(head1,head2,loop1);
        }
        ListNode cur = loop1.next;
        while(cur != loop1){
            if(cur == loop2){
                return loop1;
            }
            cur = cur.next;
        }
        return null;
    }
    public static  ListNode isCircle(ListNode head){
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
        if(fast == null || fast.next == null) {
            return null;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        ListNode head2 = null;
        // 1->2->3->4->5->null;
       ListNode head1 = new ListNode(1);
       head1.next = new ListNode(2);
       head1.next.next = new ListNode(3);
       head1.next.next.next = new ListNode(4);
       head1.next.next.next.next = new ListNode(5);
       head1.next.next.next.next.next = head1.next.next.next;


       // 1->2->3-.4->5->null
        head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        head2.next.next.next.next.next = head1.next;


        System.out.println(twoLinkQuestion(head1,head2).val);

    }
}
