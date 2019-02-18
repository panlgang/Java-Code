package www.test.java;

public class TestBST {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(4,4);
        bst.insert(1,1);
        bst.insert(5,5);
        bst.insert(2,2);
        bst.insert(3,3);
        bst.levelOrder();
//        bst.postOrder();
//        bst.inOrdre();
//        bst.preOrder();
//        System.out.println(bst.contain(5));
//        System.out.println(bst.search(6));
       // System.out.println(bst.getSize());
    }
}
