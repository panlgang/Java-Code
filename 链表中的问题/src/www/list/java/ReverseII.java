package www.list.java;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 解题思路：反转从m到n的结点，仅于四个结点有关，m，n，m的前继，n的后继
 * 依次连好既可。
 */
public class ReverseII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || n < m){
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        head = dummyHead;
        ListNode prevM = head;
        ListNode nodeN = head;
        for(int i = 1; i < m ; i++){
            if(prevM == null){
                return null;
            }
            prevM = prevM.next;   //  m的前驱结点
        }
        ListNode nodeM = prevM.next;  // m结点
        for(int i = 1; i <= n ; i++){
            if(nodeN == null){
                return null ;
            }
            nodeN = nodeN.next;    // 结点n
        }
        ListNode nextN = nodeN.next;   // 结点n的后继结点

        // 反转操作
        ListNode prev = prevM;
        ListNode cur = nodeM;
        while(cur != nextN){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        // m到n反转完成，m的前继结点指向结点n，m结点指向n的后继结点
        prevM.next = nodeN;
        nodeM.next = nextN;
        return dummyHead.next;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
     }
 }
