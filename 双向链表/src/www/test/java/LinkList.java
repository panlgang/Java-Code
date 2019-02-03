package www.test.java;

public class LinkList {
    public Node head = new Node();
    public Node last = null;
    class Node{
        Object obj;
        Node prev;
        Node next;
    }

    /**
     * 头插
     * @param obj
     */
    public void pushFront(Object obj){
        Node newnode = new Node();
        newnode.obj = obj;
        if(head.next == null){
            head.next = newnode;
            last = newnode;
            newnode.prev = null;
            return;
        }
        head.next.prev = newnode;
        newnode.next = head.next;
        newnode.prev = null;
        head.next = newnode;
    }

    /**
     * 尾插
     * @param obj
     */
    public void pushBack(Object obj){
        if(head.next == null){
            pushFront(obj);
            return;
        }
        Node tmp = last;
        Node newnode = new Node();
        newnode.obj = obj;
        last.next = newnode;
        newnode.prev = last;
        last = newnode;
    }

    /**
     * 任意位置插入
     * @param obj
     * @param pos
     */
    public void insert(Object obj,Node pos){
        if(pos == head.next){
            this.pushFront(obj);
            return;
        }
        Node cur = head.next;
        Node newnode = new Node();
        newnode.obj = obj;
        while(cur != null && cur.next != pos){
            cur = cur.next;
        }
        if(cur.next == pos){
            cur.next = newnode;
            newnode.prev = cur;
            newnode.next = pos;
            pos.prev = newnode;
            return;
        }
    }

    /**
     * 头删
     */
    public void popFront(){
        if(head.next == null || head.next.next == null){
            head.next = null;
            return;
        }
        Node del = head.next;
        head.next = del.next;
        del.next.prev = null;
    }

    /**
     * 删除任意位置的结点
     * @param pos
     */
    public void delete(Node pos){
        if(pos == null || head.next == null){
            return;
        }
        Node del = head.next;
        while(del.next != pos && del.next != null){
            del = del.next;
        }
        if(pos == last){
            del.next = null;
            last.prev = null;
            return;
        }
        if(del.next == pos){
           del.next = pos.next;
           pos.next.prev = del;
           return;
        }
        popFront();
    }

    /**
     * 遍历链表
     */
    public void printList(){
        Node cur = head.next;
        Node tmp = last;
        while(cur!= null){
            System.out.print(cur.obj + "-->");
            cur = cur.next;
        }
        System.out.println("Over");
        System.out.println();
        while(tmp!= null){
            System.out.print(tmp.obj + "-->");
            tmp = tmp.prev;
        }
        System.out.println("Over");

    }
}
