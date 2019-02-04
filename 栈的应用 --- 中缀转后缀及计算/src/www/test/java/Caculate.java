package www.test.java;

/**
 *  计算后缀表达式
 *
 *  遍历后缀表达式中的数字和fuhao
 *  对于数字、进栈
 *  对于符号：
 *         从栈中弹出右操作数，
 *         从栈中弹出左操作数，
 *         根据符号进行运算，
 *         将运算结果压入栈中
 * 遍历结果：栈中的唯一数字为计算结果
 */
public class Caculate {
    public static void main(String[] args) {
        String str = "831-5*+";
        double result = caculate(str,new StackList());
        System.out.println(result);
    }

    public static double caculate(String str, StackList st) {
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if ('0' <= arr[i] && arr[i] <= '9') {
                st.pushStack(arr[i]);
            } else {
                char ch1 = (char)st.getTop().data;
                double right = ch1 - '0';
                st.popStack();
                char ch2 = (char)st.getTop().data;
                double left = ch2 - '0';
                st.popStack();
                switch (arr[i]) {
                    case '+':
                        st.pushStack(left + right);
                        break;
                    case '-':
                        st.pushStack(left - right);
                        break;
                    case '*':
                        st.pushStack(left * right);
                        break;
                    case '/':
                        st.pushStack(left / right);
                        break;
                }
            }
        }
        return (char)st.popStack().data - '0';
    }


}
