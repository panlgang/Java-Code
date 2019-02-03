package www.test.java;

public class Test {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        for(int i = 0; i < 5; i++){
            list.pushFront(i);
        }
        for(int i = 5; i < 10; i++){
            list.pushBack(i);
        }
        //list.insert(100,list.head.next);
        //list.popFront();
        list.printList();
        list.delete(list.head.next.next.next.next);
        list.printList();
    }
}
