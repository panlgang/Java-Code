package Day18;

/**
 * @auther plg
 * @date 2019/6/9 21:11
 */
public class Mirror {
    private static class Node{
        Node left;
        Node right;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }
    public static void swap(Node root){

    }
    private static Node process(Node root){
        if(root == null ){
            return root;
        }
        Node temp = root.left;
        root.right = process(root.left);
        root.left = process(temp);
        return root;
    }
}
