package www.test.java;

public class BST {
    private Node root = null;
    private int size = 0;

    public class Node{
        int key;
        int value;
        Node leftChild;
        Node rightChild;
        public Node(int key,int value,Node leftChild,Node rightChild){
            this.key = key;
            this.value = value;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
    private Node insert(Node root, int key, int value){
        if(root == null){
            root = new Node(key,value,null,null);
            size++;
            return root;
        }
        if(root.key > key){
            root.leftChild = insert(root.leftChild,key,value);
        }else if(root.key < key){
            root.rightChild = insert(root.rightChild,key,value);
        }else{
            root.value = value;
        }
        return root;
    }

    private boolean contain(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.key == key){
            return true;
        }
        if(root.key < key){
            return contain(root.rightChild,key);
        }else {
            return contain(root.leftChild,key);
        }

    }

    private int search(Node root,int key){
        if(root == null){
            throw new RuntimeException("not found!");
        }
        if(root.key == key){
            return root.value;
        }else if(root.key > key){
            return search(root.leftChild,key);
        }else{
            return search(root.rightChild,key);
        }
    }

    private void  preOrder(Node root){
        if(root != null){
            System.out.print(root.key + "、");
            preOrder(root.leftChild);
            preOrder(root.rightChild);
        }
    }

    private void inOrdre(Node root){
        if(root != null){
            inOrdre(root.leftChild);
            System.out.print(root.key + "、");
            inOrdre(root.rightChild);
        }
    }

    private void postOrder (Node root){
        if(root != null){
            postOrder(root.leftChild);
            postOrder(root.rightChild);
            System.out.print(root.key + "、");
        }
    }





    public int getSize(){
        return this.size;
    }


    public boolean isEmpty(){
        return this.size == 0;
        //return this.Node == null;
    }

    //二分搜素树中插入元素
    public void insert(int key,int value){
        this.root = insert(root,key,value);
    }

    //是否包含某个结点
    public boolean contain(int key){
        return contain(root,key);
    }
    //二分搜素树中查找结点,返会value值
    int search(int key){
       return search(root,key);
    }

    //前序遍历
    public void preOrder(){
        preOrder(root);
    }
    //中序遍历
    public void inOrdre(){
        inOrdre(root);
    }
    //后序遍历
    public void postOrder(){
        postOrder(root);
    }

    //层序遍历，使用队列
    public void levelOrder(){
        Queue queue = new Queue();
            queue.inQueue(root);
            while(!queue.isEmpty()){
                Node node = queue.outQueue();
                System.out.print(node.key + "、");
                if(node.leftChild != null){
                    queue.inQueue(node.leftChild);
                }
                if(node.rightChild != null){
                    queue.inQueue(node.rightChild);
                }
            }
    }


}
