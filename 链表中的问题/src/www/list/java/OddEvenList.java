package www.list.java;

import javax.swing.*;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * 请尝试使用原地算法完成。
 * 你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 */
public class OddEvenList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode curOdd = oddHead;
        ListNode curEven = evenHead;
        Boolean fleg = true;
        ListNode cur = head;
        while(cur != null){
            if(fleg ){
                curOdd.next = cur;
                fleg = false;
                curOdd = curOdd.next;
            }else{
                curEven.next = cur;
                fleg = true;
                curEven = curEven.next;
            }
            cur = cur.next;
        }
        curEven.next = null;
        curOdd.next = evenHead.next;
        return oddHead.next;

    }
}
