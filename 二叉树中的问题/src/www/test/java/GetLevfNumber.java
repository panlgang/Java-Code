package www.test.java;

public class GetLevfNumber {
    /**
     * 计算叶子结点个数
     * @param root
     * @return
     */
    public static int getLevfNumber(Node root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int left = getLevfNumber(root.left);
        int right = getLevfNumber(root.right);
        return left + right;
    }
}
