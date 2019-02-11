package www.test.java;
import www.test.java.*;
public class Tree {
    public static void main(String[] args) {
        Node root = new Node(0);
        Node A = new Node(1);
        Node B = new Node(2);
        Node C = new Node(3);
        Node D = new Node(4);
        Node E = new Node(5);
        Node F = new Node(6);

        root.leftChild = A;
        root.rightChild = D;
        A.leftChild = B;
        A.rightChild = C;
        D.leftChild = E;
        D.rightChild = F;
        System.out.println("先序遍历");
        preorder(root);
        System.out.println("中序遍历");
        inorder(root);
        System.out.println("后序遍历");
        postorder(root);
    }

    public static void preorder(Node root){  //先序遍历

        if(root == null){
            return;
        }
        System.out.println(root.data);
        preorder(root.leftChild);
        preorder(root.rightChild);
    }
    public static void inorder(Node root){   //中序遍历

        if(root == null){
            return;
        }
        inorder(root.leftChild);
        System.out.println(root.data);
        inorder(root.rightChild);

    }
    public static void postorder(Node root){   //后序遍历

        if(root == null){
            return;
        }
        postorder(root.leftChild);
        postorder(root.rightChild);
        System.out.println(root.data);

    }








}
