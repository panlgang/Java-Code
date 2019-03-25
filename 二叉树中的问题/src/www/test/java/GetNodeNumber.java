package www.test.java;

/**
 * @auther plg
 * @date 2019/3/24 11:49
 */
public class GetNodeNumber {
    /**
     * 在小于O（n）的时间复杂度内，统计完全二叉树的结点个数
     * @param root
     * @return
     */
    public static int getNodeNumber(Node root){
        if(root == null){
            return 0;
        }
        return bs(root,1,mostLeftLevel(root,1));
    }

    /**
     *  每一层只会遍历一个结点，遍历其左边界
     * @param root  当前结点
     * @param level 当前结点所在的层数
     * @param h     整课树的高度
     * @return
     */
    private static int bs(Node root,int level,int h){
        if(level == h){
            // 叶子结点
            return 1;
        }
        if(mostLeftLevel(root.right,level + 1) == h){
            //右子树来到最后一层，说明左子树是满的
            // 递归处理左边
            return (1 << (h - level) + bs(root.right,level + 1,h));

        }else{  //右子树是满的，只是层数少一层
                // 递归处理右边
            return (1 << (h - level - 1) + bs(root.left,level + 1,h));
        }
    }

    // 计算以root为根的完全二叉树的层数
    private static int mostLeftLevel(Node root,int level){
        while(root != null){
            level++;
            root = root.left;
        }
        return level - 1;
    }
}
