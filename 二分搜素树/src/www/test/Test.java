package www.test;

/**
 * 二分搜索树练习
 * @auther plg
 * @date 2019/4/16 16:19
 */
public class Test {
    public static void main(String[] args) {
        BST<Integer,String> bst = new BST<>();
        bst.put(3,"hehe");
        bst.put(5,"Lucy");
        bst.put(2,"Jack");
        bst.put(1,"Tom");
        bst.put(4,"Danny");
        bst.put(1,"Tim");
        bst.levelOrder();
        System.out.println("++++++++++++++++++++");
        bst.preOrder();
        System.out.println("++++++++++++++++++++");
        bst.inOrder();

    }
}
