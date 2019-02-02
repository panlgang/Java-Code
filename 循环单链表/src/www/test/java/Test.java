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
        list.deleteNode(list.head.next);
        boolean ret = list.findNode(9);
        int len = list.getListLength();
        System.out.println(len);
        //System.out.println(ret);
        list.printList();
    }
}
