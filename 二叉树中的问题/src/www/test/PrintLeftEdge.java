package www.test.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的左视图
 * @auther plg
 * @date 2019/6/1 10:12
 */
public class PrintLeftEdge {
    public static void printLeftEdge(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node first = root;
        Node nfirst = null;
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root.left != null){
                queue.offer(root.left);
            }
            if(root.right != null){
                queue.offer(root.right);
            }
            // 即使会指向里边的结点，但下一次会覆盖掉
            nfirst = root.left == null ? root.right : root.left;
            if(root == first){
                System.out.println(root.data);
                first = nfirst;
            }
        }
    }
}
