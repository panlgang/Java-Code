package www.test.java;

public class Tree {
    Node root = new Node();
    class Node{
        int data;
        Node leftChild;
        Node rightChild;
        public Node(){}
        public Node(int data){
            this.data = data;
        }
    }
    public Node generateTree(){
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
        return root;
    }
}
