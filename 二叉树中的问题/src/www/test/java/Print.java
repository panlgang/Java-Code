package www.test.java;

import java.util.Stack;

public class Print {
    /**
     * 非递归实现二叉树的先序遍历  ----- 中，左，右
     * 有右先压右，有左后压左
     * 弹出时则顺序颠倒
     * @param root
     */
    public static void preOrderUnR(Node root){
        if(root == null){
            return;
        }
        System.out.println("preOrder : ");
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            System.out.print(root.data + " ");
            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.add(root.left);
            }
        }
        System.out.println();
    }

    /**
     * 当前结点不为null，入栈，当前结点向右走
     * 当前结点为null，从栈中弹出元素，当前结点向右走。
     * @param root
     */
    public static void inOrderUnR(Node root){
        System.out.println("InOrder : ");
        Stack<Node> stack = new Stack<Node>();
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                System.out.println(root.data + " ");
                root = root.right;
            }
        }
        System.out.println();
    }

    /**
     * 中左右（先序） --> （改变压栈顺序） 中右左 ---> （栈）逆序
     * 两个栈操作
     * @param root
     */
    public static void postOrderUnR(Node root){
        System.out.println("PostOrder : ");
        if(root != null){
            Stack<Node> stack1 = new Stack<Node>();
            Stack<Node> stack2 = new Stack<Node>();
            stack1.add(root);
            while(!stack1.isEmpty()){
                root = stack1.pop();
                stack2.push(root);
                if(root.left != null){
                    stack1.push(root.left);
                }
                if(root.right != null){
                    stack1.push(root.right);
                }
            }
            while(!stack2.isEmpty()){
                root = stack2.pop();
                System.out.print(root.data + " ");
            }
        }

    }
}
