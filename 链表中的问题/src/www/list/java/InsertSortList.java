package www.list.java;

/**
 * 对链表进行插入排序，直接移动结点
 */
public class InsertSortList {
    public static ListNode insertSort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode tail = head;          // 有序部分的最后一个结点
        ListNode cur = head.next;     //  无序部分的第一个结点
        while(cur != null){
            ListNode first = dummyNode.next;   // 有序部分的第一个结点
            ListNode tmp = cur.next;    // 保存下一个结点
            tail.next = null;           // 防止后面串很多，错误
            if(cur.val <= first.val){
                // 头插
                dummyNode.next = cur;
                cur.next = first;

            }else if(cur.val > tail.val) {
                // 尾插
                tail.next = cur;
                tail = cur;
            }else{
                // 找到中间合适的位置
                ListNode prev = null;
               while(first != tail && first.val < cur.val){
                   prev = first;
                   first = first.next;
               }
//               if( first.val > cur.val){    // 找到了该插入的位置
//                   cur.next = first;
//                   prev.next = cur;
//               }
//               else{
//                   cur.next = first;
//                   prev.next = cur;
//               }
                cur.next = first;
                prev.next = cur;
            }
            cur = tmp;

        }
        return dummyNode.next;
    }

}
