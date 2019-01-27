public class Test {
    public static void main(String[] args) {
        fjStrinig(3);
    }
    public static void fjStrinig(int n){
        if(n == 1){
            System.out.print("A");
        }else{
            fjStrinig(n -1);
            System.out.print((char)('A' + n - 1));
            fjStrinig(n - 1);
        }
    }
}
