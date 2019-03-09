package www.list.java;

/**
 * 将链表旋转K位
 * 1.类似数组三次逆序 ---- 超出限制
 * 2.找到倒数第K个,然后作为头,将前面的结点串上去;
 */
public class RevolveList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null ){
            return head;
        }
        // 统计长度
        ListNode cur = head;
        int length = 0;
        while(cur != null){
            cur = cur.next;
            length++;
        }
        // 找倒数第K个
        k = k % length;
        if(k == 0){
            //  无需处理
            return head;
        }
        ListNode fast = head;
        ListNode low = head;
        while(k > 0){
            fast = fast.next;
            k--;
        }
        ListNode prev = head;
        ListNode tail = fast;
        while(fast != null){
            tail = fast;
            fast = fast.next;
            prev = low;
            low = low.next;
        }
        prev.next = null;
        tail.next = head;
        return low;
    }
}
