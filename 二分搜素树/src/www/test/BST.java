package www.test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther plg
 * @date 2019/4/16 15:24
 */
public class BST<K,V> {
    private Node<K,V> root;
    private Integer count = 0;
    public static class Node<K,V> implements Comparable<K>{
        private K key;
        private V val;
        private Node<K,V> left;
        private Node<K,V> right;
        public Node(K key,V val){
            this.key = key;
            this.val = val;
        }

        @Override
        public int compareTo(K key) {
            if(key == null){
                throw new RuntimeException("nullPointException");
            }
            if(this.key.equals(key)){
                return 0;
            }
            return this.key.hashCode() - key.hashCode();
        }
    }
    private Node<K,V> put(Node<K,V> root,K key,V val){
        if(root == null){
            count++;
            return root = new Node<K,V>(key,val);
        }
        if(root.compareTo(key) == 0){
            root.val = val;
        }else if(root.compareTo(key) > 0){
            root.left =  put(root.left,key,val);
        }else{
            root.right =  put(root.right,key,val);
        }
        return root;
    }
    private boolean contains(Node<K,V> root,K key){
        if(this.root == null){
            return false;
        }
        if(root.compareTo(key) == 0){
            return true;
        }else if(root.compareTo(key) > 0){
            return contains(root.left,key);
        }else{
            return contains(root.right,key);
        }
    }
    private V get(Node<K,V> root, K key){
        if(root == null){
            throw new RuntimeException("key is illegal");
        }
        if(contains(key)){
            if(root.compareTo(key) == 0){
                return root.val;
            }else if(root.compareTo(key) > 0){
                return get(root.left,key);
            }else{
                return get(root.right,key);
            }
        }else{
            throw new RuntimeException("key is illegal");
        }
    }
    private void levelOrder(Node<K,V>root){
        if(root != null) {
            LinkedList<Node<K, V>> queue = new LinkedList<Node<K,V>>();
            queue.offer(root);
            while(!queue.isEmpty()){
                root = queue.poll();
                System.out.println(root.key + "====" + root.val + " ");
                if(root.left != null){
                   queue.offer(root.left);
                }
                if(root.right != null){
                    queue.offer(root.right);
                }
            }
        }

    }
    private void preOrder(Node<K,V> root){
        if(root == null){
            return;
        }
        System.out.println(root.key + "====" + root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    private void inOrder(Node<K,V>root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.key + "====" + root.val);
        inOrder(root.right);

    }
    private void postOrder(Node<K,V> root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.key + "====" + root.val);
    }
    public boolean put(K key,V val){
         root = put(root,key,val);
         return true;
    }
    public boolean contains(K key){
        return contains(root,key);
    }
    public V get(K key){
        return get(root,key);
    }
    public void levelOrder(){
        levelOrder(root);
    }
    public void preOrder(){preOrder(root);}
    public void inOrder(){inOrder(root);}
    public void postOrder(){postOrder(root);}
}
