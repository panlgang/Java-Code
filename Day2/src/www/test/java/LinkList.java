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
         * 空链表
         * 非空链表
         * 分情况讨论
         */

        Node newNode = new Node(obj);
        if(head.next == null){
            head.next = newNode;
            //newNode.next = null;
            return;
        }
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
            head.next = newNode;
            return;
        }
        Node cur = head.next;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
    }

    /**
     *
     * @param obj  插入节点的数据
     * @param pos  插入到某个位置（前面）
     *             分为没有节点（只能插到头的后面）
     *             普通情况
     */
    public void insertNode(Object obj,Node pos){
//        if(pos == null ){
////            System.out.println("hh");
////            return;
////       }
        Node newNode = new Node(obj);
        if(pos == head.next){
            newNode.next = head.next;
            head.next = newNode;
            return;
        }
        Node cur = head.next;
        while(cur.next != null){
            if(cur.next == pos){
                cur.next = newNode;
                newNode.next = pos;
                return;
            }
            cur = cur.next;
        }
    }

    /**
     * 头删,空链表不用删除
     */
    public void popFront(){
        if(head.next == null){
            return;
        }
       head.next = head.next.next;
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
        if(head.next.next == null){
            head.next = null;
            return;
        }
        Node cur = head.next;
        while(cur.next.next != null){
            cur = cur.next;
        }
        cur.next = null;

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
            pos.next = null;
        }
    }

}
