package www.test.java;

/**
 *中缀转后缀算法
 * 遍历表达式中的数字和符号
 * 对于数字，直接输出
 * 对于符号：
 *          左括号 ：进栈
 *          运算符号：与栈顶符号优先级进行比较
 *          若栈顶符号优先级低，则该符号进栈（默认左括号优先级最低）
 *          若栈顶符号优先级不低，将栈顶符号弹出并输出之后该符号进栈
 *          右括号：将栈顶符号弹出并输出，直到匹配到左括号
 *          遍历结束，将栈中的所有符号弹出并输出
 */
public class Convert {
    public static void main(String[] args) {
        StackList st = new StackList();
        String str = "8 + (3 - 1) * 5";
        transform(str,st);
    }
    public static void transform(String str,StackList st){
        char[] help = str.toCharArray();
        for(int i = 0; i < help.length ; i++){
            if('0' <= help[i] && help[i] <= '9'){  //数字 输出
                System.out.print(help[i]);
            }else if(help[i] == '('){            //左括号入栈
                st.pushStack(help[i]);
            }else if(help[i] == '*' || help[i] == '/' || help[i] == '+' || help[i] == '-'){ //其它运算符号
                if(st.getTop() == null || priority((char)st.getTop().data) < priority(help[i])){
                    st.pushStack(help[i]);
                }else{
                    System.out.print(st.popStack().data);
                    st.pushStack(help[i]);
                }
            }else if(help[i] == ')'){
               while((char)st.getTop().data != '('){
                   System.out.print(st.popStack().data);
               }
               st.popStack();     //匹配到左括号只弹出不输出
            }
        }
        while(st.head.next != null){
            System.out.print(st.popStack().data);
        }
    }
    public static int priority(char ch){
        int ret = 0;
        if(ch == '+' || ch == '-'){
            ret = 1;
        }else if(ch == '*' || ch == '/'){
            ret = 2;
        }
        return ret;
    }
}
