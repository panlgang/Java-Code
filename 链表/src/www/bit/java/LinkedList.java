package www;

public class LinkedList {
    private Node head = null;  //链表头
    private  class Node{      // private对内部类进行封装隐藏
        private  int data;    // 数据域
        private  Node next;   //指针域（地址域）
        public Node(){
            // 无参构造
        }
        public Node(int data){
            this.data = data;
        }
        public Node(int data,Node next){
            this.data = data;
            this.next = next;
        }
    }
    public LinkedList(){
        //外部类的构造方法
        head = new Node(0);
    }
    //  实现头插结点
    public void addFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head.next;
        head.next = newNode;
    }
    //实现尾插结点
    public void addEnd(int data){
        Node newNode = new Node(data);
        Node cur = head;
        while(cur.next != null){
            cur = cur.next;
        }
        cur.next = newNode;
        newNode.next = null;
    }
    //删除结点，返回删除结点的数据
    public int deleteNode(int index){
        Node dummyHead = new Node(-1); // 任意值都行
        dummyHead.next = head;
        Node cur = dummyHead;
        //找前驱结点
        for(int i = 1; i < index;i++){
            if(cur != null){
                cur = cur.next;
            }else{
                throw new IndexOutOfBoundsException("参数越界 index :" + index);
            }
        }
        Node delNode = cur.next;
        int ret = delNode.data;
        cur = delNode.next;
        delNode = null;
        return ret;
    }
    //根据索引查找结点
    public int findNode(int index){
        Node cur = head;
        for(int i = 1; i < index; i++){
            if(cur != null){
                cur = cur.next;
            }else{
                throw new IndexOutOfBoundsException("参数越界 index :" + index);
            }
        }
        return cur.data;
    }
    //修改指定索引的结点的值,返回原始值
    public int setNode(int index,int data){
        Node cur = head;
        for(int i = 1; i < index; i++){
            if(cur != null){
                cur = cur.next;
            }else{
                throw new IndexOutOfBoundsException("参数越界 index :" + index);
            }
        }
        int ret = cur.data;
        cur.data = data;
        return ret;
    }
}


