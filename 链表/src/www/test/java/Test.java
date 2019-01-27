package www.test.java;
public class Test {
    public static void main(String[] args) {
        LinkList list = new LinkList();
        for(int i = 5; i >= 0; i--){
            list.pushFront(i);
        }
//        for(int i = 6; i <= 10; i++){
//            list.pushBack(i);
//        }
        //list.insertNode(10,list.head.next);
        list.modifyNode(list.head.next.next,100);
        list.printList();
       // list.popFront();
        //list.popBack();
       // list.delete(list.head.next.next);
       // list.reverseList();
        //System.out.println(list.getListLength());
        //System.out.println(list.findNode(5).obj);
        //list.printList();


    }
}
