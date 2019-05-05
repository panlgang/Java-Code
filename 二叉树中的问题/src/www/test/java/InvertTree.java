package www.test.java;

/**
 * 反转一棵二叉树
 * @auther plg
 * @date 2019/5/5 17:28
 */
public class InvertTree {
    public static Node invertTree(Node root){
        if(root == null){
            return root;
        }
        Node temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
