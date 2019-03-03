package www.test;

public class SequenceBaseList implements Sequence {
    private Node dummyNode;
    private int size;
    public SequenceBaseList(){
        dummyNode = new Node(null);
        size = 0;
    }
    private class Node{
        private Object data;
        private Node next;
        public Node(Object data){
            this.data = data;
        }
    }

    @Override
    public void add(Object data) {
        add(data,size);
    }

    @Override
    public boolean delete(int index) {
        rangeCheck(index);
        Node cur = dummyNode;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        Node delNode = cur.next;
        cur.next = delNode.next;
        delNode = null;
        size--;
        return true;
    }

    @Override
    public int find(Object obj) {
        int i = 0;
        Node cur = dummyNode.next;
        while(cur != null){
            if(cur.data == obj){
                return i;
            }else{
                i++;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object obj) {
        return find(obj) > -1;
    }

    @Override
    public Object set(int index, Object obj) {
        Node cur = dummyNode.next;
        for(int i = 0; i < index; i++){
            cur = cur.next;
        }
        Object ret = cur.data;
        cur.data = obj;
        return ret;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        Node cur = dummyNode.next;
        while(cur != null){
            Node tmp = cur.next;
            cur.next = null;
            cur = tmp;
        }
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Object[] toArray() {
        Node cur = dummyNode.next;
        int len = 0;
        while(cur != null){
            cur = cur.next;
            len++;
        }
        Object[] arr = new Object[len];
        int i = 0;
        cur = dummyNode.next;
        while(cur != null){
            arr[i++] = cur.data;
            cur = cur.next;
        }
        return arr;
    }
    public void print(){
        Node cur = dummyNode.next;
        while(cur != null){
            System.out.print(cur.data + "、");
            cur = cur.next;
        }
        System.out.println();
    }
    private void rangeCheck(int index){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("索引越界： index" + index);
        }
    }
    private void add(Object data,int index){
        Node prev = dummyNode;
        for(int i = 0; i < index; i++){
            prev = prev.next;
        }
        Node newNode = new Node(data);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

}
