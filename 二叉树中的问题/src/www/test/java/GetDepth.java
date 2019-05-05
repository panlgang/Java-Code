package www.test.java;

/**
 * 获取二叉树的最大深度
 * @auther plg
 * @date 2019/5/5 17:02
 */
public class GetDepth {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(1);
        Node node3 = new Node(1);
        Node node4 = new Node(1);
        Node node5 = new Node(1);
        {
            node1.left = node2;
            node1.right = node3;
            node2.left = node4;
            node2.right = null;
            node4.left = null;
            node4.right = node5;
        }

        System.out.println(getDepth(node1));
    }
    public static int getDepth(Node root){
        if(root == null){
            return 0;
        }
        int leftMax = getDepth(root.left);
        int rightMax = getDepth(root.right);
        return Math.max(leftMax,rightMax) + 1;
    }
}
