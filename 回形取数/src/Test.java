public class Test {
    public static void main(String[] args) {
        //int[][] arr = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] arr = new int[][]{{1,2},{3,4},{5,6}};
        printEdge(arr);
    }

    /**
     * 整体把控思想，逐圈打印
     * （row1,col1）  //左上角坐标
     * (row2,col2)    //右下角坐标
     * @param arr
     */
    public static void printEdge(int[][] arr){
        int row1 = 0;
        int col1 = 0;
        int row2 = arr.length - 1;
        int col2 = arr[0].length - 1;
        while(col1 <= col2 && row1 <= row2){
            printEdge(arr,row1++,col1++,row2--,col2--);   //逐层打印
        }
    }
    public static void printEdge(int[][] arr,int row1,int col1,int row2,int col2){
        if(row1 == row2){             //只有一行
            for(int i = col1; i <= col2; i++){
                System.out.print(arr[row1][i] + " ");
            }
        }else if(col1 == col2){      //只有一列
            for(int i = row1; i <= row2; i++){
                System.out.print(arr[i][col1]);
            }
        }else{
            int curC = col1;    //记录初始值，后面的自加操作会改变初始值
            int curR = row1;    //同上
                for(;row1 < row2;row1++){    //row1 --> row2
                    System.out.print(arr[row1][col1] + " ");
                }
                for(;col1 < col2;col1++){    // col1 --> col2;
                    System.out.print(arr[row2][col1] + " ");
                }
                for(;row2 >curR; row2--){      //cow2 --> cow1
                    System.out.print(arr[row2][col2] + " ");
                }
                for(;col2 > curC;col2--){
                    System.out.print(arr[curC][col2] + " ");
                }
            }

    }
}

