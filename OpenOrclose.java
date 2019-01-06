public class OpenOrclose{
    public static void main(String[] args) {
        print(200);
    }
    public static void print(int n){
        boolean[] arr = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = false;
        }
        for(int j = 2; j <= n ;j++){
            for(int k = j; k <= n; k++){
                if(k % j == 0){
                    arr[k] = !arr[k];
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(arr[i] == false){
                System.out.print(i + "、");
            }
        }
    
    }
}
