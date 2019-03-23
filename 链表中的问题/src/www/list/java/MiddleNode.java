package www.list.java;

/**
 * @auther plg
 * @date 2019/3/23 18:44
 */
public class MiddleNode {
    public ListNode middleNode(ListNode head){
        // 空链表或者一个结点的链表
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public ListNode middleNode2(ListNode head){
        // 空链表或者一个结点的链表
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        int count = 0;
        // 计算结点个数
        while(cur != null){
            count++;
            cur = cur.next;
        }
        //重新指向头结点，准备第二次遍历
        cur = head;
        for(int i = 1; i < count / 2 + 1; i++){
            cur = cur.next;
        }
        return cur;
    }
}
