package www.test.java;

/**
 *  二叉树转化为链表
 * @auther plg
 * @date 2019/6/1 18:23
 */
public class BinTreeToLinkedList {
    public static Node process(Node root){
        if(root == null){
            return null;
        }
        Node left = process(root.left);
        Node right = process(root.right);
        root.right = left;
        root.left = null;
        if(left == null){
            root.right = right;
        }else{
            Node cur = root;
            while(cur.right != null){
                cur = cur.right;
            }
            cur.right = right;
        }
        return root;
    }
}
