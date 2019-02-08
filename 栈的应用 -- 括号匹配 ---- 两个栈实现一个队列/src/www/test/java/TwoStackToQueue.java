package www.test.java;
/**
 * 两个栈模拟一个队列
 */
public class TwoStackToQueue {
    public static void main(String[] args) {
        StackList A = new StackList();
        StackList B = new StackList();
        A.pushStack(1);
        A.pushStack(2);
        A.pushStack(3);
        A.pushStack(4);
        A.pushStack(5);
//        for(int i = 0; i < 5; i++){
//            System.out.print(A.popStack().data);
//        }
        while(A.getNode() !=  null){
            B.pushStack(A.popStack().data);
        }
        while(B.getNode()!= null){
            System.out.print(B.popStack().data + "、" );
        }
        System.out.println();
    }
}
