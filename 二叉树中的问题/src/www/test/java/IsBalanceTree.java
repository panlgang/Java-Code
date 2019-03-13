package www.test.java;

/**
 * 判断一课树是否为平衡二叉树
 */
public class IsBalanceTree {
    public static class returnData{
        private boolean isB;
        private int h;
        public returnData(boolean isB,int h){
            this.isB = isB;
            this.h =h;
        }
    }
    public static returnData isBalanceTree(Node head){
        if(head == null){
            return new returnData(false,0);
        }
        returnData leftData = isBalanceTree(head.left);
        if(!leftData.isB){    //  获取左子树的信息
            return new returnData(false,0);
        }
        returnData rightData = isBalanceTree(head.right);
        if(!rightData.isB){    //获取右子树的信息
            return new returnData(false,0);
        }
        if(Math.abs(leftData.h - rightData.h) > 1){
            return new returnData(false,0);
        }
        return new returnData(true,Math.max(leftData.h,rightData.h)+ 1);
    }
}
