package Day24;

/**
 * 剑指offer19 ： 二叉树的镜像
 * @auther plg
 * @date 2019/7/4 16:58
 */
public class Mirror {
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int data;
    }

    /**
     * 二叉树的镜像
     * 在先序遍历的过程中将每一个结点的左右孩子交换
     * @param root
     */
    public static void mirror(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;


        mirror(root.left);
        mirror(root.right);
    }

    public static TreeNode process(TreeNode root){
        if(root == null){
            return null;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = process(root.right);
        root.right = process(temp);
        return root;
    }
}
