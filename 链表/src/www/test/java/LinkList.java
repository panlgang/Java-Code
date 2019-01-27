package www.test.java;

public class LinkList {
    Node head = new Node();
    class Node {
        Node next;
        Object obj;
        public Node(){}
        public Node(Object obj){
            this.obj = obj;
        }
    }

    public void printList(){
        /**
         * 打印链表
         */
        Node cur = head.next;
        while(cur != null){
            System.out.print(cur.obj + "-->");
            cur = cur.next;
        }
        System.out.println("over");
    }

    public void pushFront(Object obj){
        /**
         * 头插节点
         * 不需要分类处理
         */

        Node newNode = new Node(obj);
        newNode.next = head.next;
        head.next = newNode;
    }

    public void pushBack(Object obj){
        /**
         *  尾插节点
         *  空链表
         * 非空链表
         */
        Node newNode = new Node(obj);
        if(head.next == null){
            newNode.next = head.next;
            head.next = newNode;
            return;
        }
        Node cur = head.next;
        while(cur.next != null){
            cur = cur.next;
        }
        //cur 指向最后一个结点
        cur.next = newNode;
        newNode.next = null;
    }

    /**
     *
     * @param obj  插入节点的数据
     * @param pos  插入到某个位置（前面）
     *             pos插到头节点的前面
     *             普通情况
     */
    public void insertNode(Object obj,Node pos){
        Node newNode = new Node(obj);
        if(pos == head.next){
            newNode.next = head.next;
            head.next = newNode;
            return;
        }
        Node cur = head.next;
        while(cur.next != null && cur.next != pos){
            cur = cur.next;
        }
        if(cur.next != null){
           cur.next = newNode;
           newNode.next = pos;
        }
    }

    /**
     * 头删,空链表不用删除
     */
    public void popFront(){
        if(head.next == null){
            return;
        }
        Node del = head.next;
        head.next = del.next;
        del = null;
       // head.next = head.next.next;
    }

    /**
     *   尾删
     *   ①空链表
     *   ②只有一个节点的链表
     *   ③普通情况
     *   遍历到倒数第二个节点,将其的next域置空
     */
    public void popBack(){
        if(head.next == null){
            return;
        }
        Node del = head.next;
        Node prev = head.next;
        if(del.next == null){
            del = null;
            head.next = null;
            return;
        }
        while(del.next != null){
            prev = del;
            del = del.next;
        }
        prev.next = null;
        del = null;

    }

    /**
     *
     * @param pos  任意位置节点
     *             空链表无需操作
     *             删除第一个节点
     *             其他节点
     *
     */
    public void delete(Node pos){
        if(head.next == null || pos == null){
            return;
        }
        if(pos == head.next){
            head.next = pos.next;
            return;
        }
        Node cur = head.next;
        while(cur.next != null && cur.next != pos){
            cur = cur.next;
        }
        if(cur.next == null){
            return;
        }else{
            cur.next = pos.next;
            pos = null;
        }
    }

    /**
     * 链表反转
     * 空链表，一个节点的链表不用反转
     * 三指针法
     */
    public void reverseList(){
        if(head.next == null || head.next.next == null){
            return;
        }
        Node cur = head.next.next;
        Node prev = head.next;
        Node tmp = head.next;
        while(cur != null){
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        head.next.next = null;    //顺序很关键
        head.next = prev;
    }

    /**
     * 获取链表长度,
     * 不需要分空链表，可以统一处理。
     * @return  链表的长度
     */
    int getListLength(){
//        if(head.next == null){
//            return 0;
//        }
        int count = 0;
        Node cur = head.next;
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 根据数据域找对应的节点。
     *
     * @param obj
     * @return
     */
    Node findNode(Object obj){
        Node cur = head.next;
        while(cur.next != null && cur.obj != obj){
            cur = cur.next;
        }
        if(cur.obj == obj){
            return cur;
        }
        return null;
    }

    /**
     * 修改对应节点的值
     * @param pos
     * @param obj
     */
    void modifyNode(Node pos,Object obj){
        if(head.next == null){
            return;
        }
        Node cur = head.next;
        while(cur != null && cur != pos){
            cur = cur.next;
        }
        if(cur == pos){
            cur.obj = obj;
        }
    }
}
