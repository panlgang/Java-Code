package Day1;

/**
 * 寻找第K大的数
 * @auther plg
 * @date 2019/5/20 19:44
 */
public class Finder {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,2,5};
        Finder finder = new Finder();
        System.out.println(finder.findKth(arr,5,3));
    }
    public int findKth(int[] arr, int n, int K) {
        if(arr == null || n == 0 || n < K){
            throw new IllegalArgumentException("参数不合法");
        }
        return findKth(arr,0,n - 1,K);
    }
    public int findKth(int[] arr,int l,int r,int k){
        int ret = partition(arr, l, r);
        if(ret == k - 1){
            return arr[ret];
        }else if(ret < k - 1){
            return findKth(arr,ret + 1,r,k);
        }else{
            return findKth(arr,l,ret - 1,k);
        }
    }
    public int partition(int[] arr,int l,int r){
        int temp = arr[r];
        int less = l - 1;
        int more = r + 1 ;
        while(l < more){
            if(arr[l] > temp){
                swap(arr,++less,l++);
            }else if(arr[l] == temp){
                l++;
            }else{
                swap(arr,l,--more);
            }
        }
        return less+1;
    }
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
