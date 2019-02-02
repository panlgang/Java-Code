package www.test.java;

public class LinkList {
    public Node head = new Node();
    class Node {
        Object obj;
        Node next;
    }

    /**
     * 头插
     * @param obj
     * 有节点和没有节点
     */
    public void pushFront(Object obj){
        Node newNode = new Node();
        newNode.obj = obj;
        Node cur = head.next;
        Node tmp = head.next;
        newNode.next = head.next;
        head.next = newNode;
        if(tmp == null){
            newNode.next = newNode;
            return;
        }
        while(tmp.next != cur ){
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }

    /**
     * 尾插结点
     * @param obj
     */
    public void pushBack(Object obj){     //尾插结点
        Node newNode = new Node();
        newNode.obj = obj;
        if(head.next == null){
            newNode.next = head.next;
            head.next = newNode;
            newNode.next = newNode;
            return;
        }
        Node cur = head.next;
        Node tmp = head.next;
        while(cur.next != tmp){   //找到尾结点
            cur = cur.next;
        }
        cur.next = newNode;
        newNode.next = tmp;
    }

    /**
     * 删除某一结点
     * @param pos
     */
    public void deleteNode(Node pos){
        if(pos == null || head.next == null){
            return;
        }
        Node cur = head.next;
        while(cur.next != pos){   //找到奥删除的结点
            cur = cur.next;
        }
        if(pos == head.next && pos.next  == pos){  //仅有一个结点，且删除第一个
            head.next = null;
            return;
        }
        if(pos == head.next && pos.next != pos){  //有多个结点，删除第一个
            Node tmp = head.next;
            while(tmp.next != head.next){   //找到尾结点
                tmp = tmp.next;
            }
            head.next = pos.next;
            tmp.next = pos.next;
            return;
        }
        cur.next = pos.next;   //普通情况

    }

    /**
     * 找某一元素
     * @param obj
     * @return
     */
    public boolean findNode(Object obj){
        if(head.next == null){
            return false;
        }
        Node cur = head.next;
        while(cur.next != head.next && cur.obj != obj){
            cur = cur.next;
        }
        if(cur.obj == obj){
            return true;
        }
        return false;
    }

    /**
     * 获取链表长度
     * @return
     */
    public int getListLength(){
        if(head.next == null){
            return 0;
        }
        Node cur = head.next;
        int count = 1;
        while(cur.next != head.next){
            count++;
            cur = cur.next;    //找到最后一个结点，找到之后并没有算最后一个结点因此count从1开始
        }
        return count;
    }

    public void printList(){
        if(head.next == null){
            return;
        }
        Node cur = head.next;
        while(cur.next != head.next){
            System.out.print(cur.obj + "-->");
            cur = cur.next;
        }
        System.out.print(cur.obj);
    }

}
