package www.test.java;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther plg
 * @date 2019/5/31 22:30
 */
public class LeverOrder {
    public static void leverOrder(Node root){
        if(root == null){
            return;
        }
        int level = 1;
        System.out.print("level " + level + ": " );
        Node last = root;
        Node nLast = null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            root = queue.poll();
            System.out.print(root.data + " ");
            if(root.left != null){
                queue.offer(root.left);
                nLast = root.left;
            }
            if(root.right != null){
                queue.offer(root.right);
                nLast = root.right;  // nlast 指向每一层最右的结点
            }
            // 来到最后一个结点
            if(last == root && ! queue.isEmpty()){  // 判断队列为空很关键。
                System.out.print("\nlevel " + (++level) + ": ");
                last = nLast;
            }
        }
    }
}
