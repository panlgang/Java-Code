package www.test.java;

public class FIndNode {
    public static Node findNode(Node root,int data){
        if(root == null){
            return null;
        }
        if(root.data == data){
            return root;
        }
        Node result = findNode(root.left,data);
        if(result != null){
            return result;
        }
        return findNode(root.right,data);
    }
}
