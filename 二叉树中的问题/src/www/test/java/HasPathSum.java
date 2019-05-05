package www.test.java;

/**
 * 112题
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 * @auther plg
 * @date 2019/5/5 18:08
 */
public class HasPathSum {
    public static boolean hasPathSum(Node root,int sum){
        if(root == null){
            return false;
        }
        if(root.left == null && root.right == null){
            return root.data == sum;
        }
        return hasPathSum(root.left,sum - root.data) || hasPathSum(root.right,sum - root.data);
    }
}
