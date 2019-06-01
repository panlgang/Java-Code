package www.test.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的右视图
 * @auther plg
 * @date 2019/6/1 9:12
 */
public class PrintRightEdge {
    public static void printRightEdge(Node root){
        if(root == null){
            return;
        }
        Node last = root;  // 记录当前行的最右结点
        Node nlast = null; // 记录下一行的最右结点
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            if(root.left != null){
                queue.offer(root.left);
                nlast = root.left;
            }
            if(root.right != null){
                queue.offer(root.right);
                nlast = root.right;
            }
            if(last == root){
                System.out.print(last.data + " ");
                last = nlast;
            }
        }
    }

}
