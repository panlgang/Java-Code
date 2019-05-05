package www.test.java;

/**
 * @auther plg
 * @date 2019/5/5 16:50
 */
public class Contain {
    public static void main(String[] args){

    }
    public static boolean contain(Node root,int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        if(contain(root.left,key) || contain(root.right,key)){
            return true;
        }
        return false;
    }

}
