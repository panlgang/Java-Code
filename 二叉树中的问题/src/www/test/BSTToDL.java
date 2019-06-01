package www.test.java;

/**
 * 搜素二叉树转换成有序双向链表
 * @auther plg
 * @date 2019/6/1 17:00
 */
public class BSTToDL {
   public static Node bSTToDL(Node root){
       if(root == null){
           return null;
       }
       return process(root)[0];
   }

    private static Node[] process(Node root) {
       if(root == null){
           return new Node[]{null,null};
       }
       Node[] left = process(root.left);
       Node[] right = process(root.right);
       if(left[1] !=  null){
           left[1].right = root;
           root.left = left[1];
       }
       if(right[0] != null){
           root.right = right[0];
           right[0].left = root;
       }
       Node head = left[0] == null ? root : left[0];
       Node tail = right[1] == null ? root : right[1];
       return new Node[]{head,tail};
    }
}
