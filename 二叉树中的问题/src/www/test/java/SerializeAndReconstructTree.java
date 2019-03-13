package www.test.java;

/**
 * 序列化与反序列化
 */
public class SerializeAndReconstructTree {
    public static String serialByPre(Node root){
        if(root == null){
            return "#_";
        }
        String res = root.data + "_";
        res += serialByPre(root.left);
        res += serialByPre(root.right);
        return res;
    }
//    public static Node reconByPreString(String str){
//
//    }
}
