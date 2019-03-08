package www.list.java;

/**
 * 基于冒泡排序法对链表进行排序
 */
public class BubbleSortList {
    public static void bubbleSortList(ListNode head){
        if(head == null || head.next == null){
            return;
        }
        ListNode tail = null;
        while(tail != head){      // 控制趟数
            ListNode cur = head;
            ListNode next = head.next;
            while(next != tail ) { // 控制比较次数
                if (cur.val > next.val) {     // 值的交换，非结点的交换
                    int tmp = cur.val;
                    cur.val = next.val;
                    next.val = tmp;
                }
                cur = cur.next;
                next = next.next;
            }
            tail = cur;
        }
    }
}
