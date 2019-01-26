package www.test.java;
import  www.bit.java.*;
public class Test {
    public static void main(String[] args) {
        LinkList list = new LinkList();
//        for(int i = 5; i >= 0; i--){
//            list.pushFront(i);
//        }
//        for(int i = 6; i < 10; i++){
//            list.pushBack(i);
//        }
        list.insertNode(20,list.head.next);
        list.insertNode(30,list.head.next);
        list.printList();
        list.delete(list.head.next);
        list.delete(list.head.next);

//        list.popFront();
//        list.popBack();
        list.printList();

    }
}
