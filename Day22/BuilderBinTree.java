package Day22;

import java.util.Arrays;

/**
 * @auther plg
 * @date 2019/7/1 16:34
 */
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
    }
}
public class BuilderBinTree {
    /**
     *
     * 剑指offer 6： 重建二叉树（根据先序和中序数组）
     * @param preorder
     * @param inorder
     * @return
     */
    public static TreeNode construct(int[] preorder,int[] inorder){
        if(preorder == null || inorder == null){
            return null;
        }
        if(preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length){
            return null;
        }
        int rootData = preorder[0];
        int i = 0;
        for( i = 0; i < inorder.length; i++){
            if(rootData == inorder[i]){
                break;
            }
        }
        TreeNode root = new TreeNode(rootData);
        root.left = construct(Arrays.copyOfRange(preorder,1,i+1),Arrays.copyOfRange(inorder,0,i));
        root.right = construct(Arrays.copyOfRange(preorder,i+1,preorder.length),Arrays.copyOfRange(inorder,i+1,inorder.length));
        return root;
    }

    /**
     * 根据后序和中序遍历数组构建二叉树
     * @param inorder
     * @param postOrder
     * @return
     */
    public static TreeNode build(int[] inorder,int[] postOrder){
        if(inorder == null || postOrder == null){
            return null;
        }
        if(inorder.length == 0 || postOrder.length == 0){
            return null;
        }
        int rootData = postOrder[postOrder.length - 1];
        int i = 0;
        for(; i < inorder.length; i++){
            if(rootData == inorder[i]){
                break;
            }
        }
        TreeNode root = new TreeNode(rootData);
        root.left = build(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postOrder,0,i));
        root.right = build(Arrays.copyOfRange(inorder,i+1,inorder.length),Arrays.copyOfRange(postOrder,i,postOrder.length - 1));
        return root;
    }
}
