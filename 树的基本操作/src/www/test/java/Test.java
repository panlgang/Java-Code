package www.test.java;

public class Test {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = tree.generateTree();
        int count = getLeavesNodeCount(tree.root);
        System.out.println(count);
        int depth = getDepthTree(tree.root);
        System.out.println(depth);
        Tree.Node retTree = copyTree(tree.root);
        System.out.println(getDepthTree(retTree));

    }

    /**
     * 求树的叶子数
     * @param root
     * @return
     */
    public static int getLeavesNodeCount(Tree.Node root){
        if(root != null) {
            if (root.leftChild == null && root.rightChild == null) {
               return 1;
            }
            return getLeavesNodeCount(root.rightChild) +
                    getLeavesNodeCount(root.leftChild);
        }
       return 0;
    }

    /**
     * 求树的高度
     * 
     * @param root
     * @return
     */
    public static int getDepthTree(Tree.Node root){
        if(root != null){
            return 1 + (getDepthTree(root.leftChild) > getDepthTree(root.rightChild) ?
                    getDepthTree(root.leftChild): getDepthTree(root.rightChild));
        }
        return 0;
    }

    /**
     * copy树
     * @param root
     * @return
     */
    public static Tree.Node copyTree(Tree.Node root){
       if(root != null){
           Tree newTree = new Tree();
           newTree.root.data = root.data;
           newTree.root.leftChild = copyTree(root.leftChild);
           newTree.root.rightChild = copyTree(root.rightChild);
           return newTree.root;
       }
       return null;
    }
}
