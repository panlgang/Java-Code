package www.test;

public class DoubleLinkedList implements Sequence {
    private Node head;
    private Node tail;
    private int size;
    private class Node{
        private Object data;
        private Node prev;
        private Node next;
        public Node(Object data){
            this.data = data;
        }
        public Node(Object data,Node next,Node prev){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    @Override
    public void add(Object data) {
        Node newNode;
        if(head == null){
            newNode = new Node(data,null,null);
            head = newNode;
            tail = newNode;
        }else{
            newNode = new Node(data);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        //addNode(size,data);
    }

    @Override
    public boolean delete(int index) {
        rangeCheck(index);
        Node delNode = findNode(index);
        Node nNext = delNode.next;
        Node nprev = delNode.prev;
        if(nNext == null){  //tail.next = null;
            //尾删
            tail = tail.prev;
            tail.next = null;
           // delNode.data = delNode.next = delNode.prev = null;
        }else if(nprev == null){
            //头删
            head = head.next;
            head.prev = null;
            //delNode.data = delNode.next = delNode.prev = null;
        }else{
            // 中间删
            nprev.next = nNext;
            nNext.prev = nprev;
            //delNode.data = delNode.next = delNode.prev = null;
        }
        delNode.data = delNode.next = delNode.prev = null;
        this.size--;
        return true;
    }

    @Override
    public int find(Object obj) {
        Node cur = head;
       for(int i = 0; i < size; i++){
           if(obj == null){
               if(cur.data == null){
                   return i;
               }
           }else{
               if(obj.equals(cur.data)){
                   return i;
               }
           }
           cur = cur.next;
       }
       return -1;
    }

    @Override
    public boolean contains(Object obj) {
        return find(obj) != -1;
    }

    @Override
    public Object set(int index, Object obj) {
        rangeCheck(index);
        Node node = findNode(index);
        Object retData = node.data;
        node.data = obj;
        return retData;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void clear() {
        Node cur = head;
        while(cur != null){
            Node tmp = cur.next;
            cur.data = cur.next = cur.prev = null;
            cur = tmp;
            this.size--;
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        Node cur = head;
        while(cur != null){
            arr[i++] = cur.data;
            cur = cur.next;
        }
        return arr;
    }

    private void rangeCheck(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("越界index : " + index);
        }
    }
    private Node findNode(int index){
        rangeCheck(index);
        Node cur = null;
        if(index <= (size >> 1)){
            cur = head;
            for(int i = 0; i < index; i++){
                cur = cur.next;
            }
        }else{   // index > (size >> 1
            cur = tail;
            for(int i = size - 1; i < index; i--){
                cur = cur.prev;
            }
        }
        return cur;
    }

    private void addNode(int index,Object data){
        rangeCheck(index);
        Node node = findNode(index);
        Node nPrve = node.next;
        Node nNext = node.prev;
        Node newNode = new Node(data);
        if(nPrve == null){  // 头插
            newNode.next = head;
            head.prev = newNode;
            newNode.prev = null;
            head = newNode;
        }else if(nNext == null){  // 尾插
            tail.next = newNode;
            newNode.prev = tail;
            tail.next = null;
            tail = newNode;
        }else{   //中间插
            newNode.next = node;
            node.prev = newNode;
            newNode.prev = nPrve;
            nPrve.next = newNode;
        }

    }
}
