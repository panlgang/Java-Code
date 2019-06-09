package Day10;

import java.util.*;

/**
 * @auther plg
 * @date 2019/5/28 13:16
 */
public class KNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while(in.hasNext()){
            String str = in.nextLine();
            String[] arr = str.split(" ");
            for(int i = 0; i < arr.length - 1; i++){
                list.add(Integer.parseInt(arr[i]));
            }
           int k = Integer.parseInt(arr[arr.length - 1]);
            Collections.sort(list);
            for(int i = 0; i < k; i++){
                System.out.print(list.get(i) + " ");
            }
            //process(list,3);
        }

    }
    public static void process(List<Integer> list,int k){
        Queue<Integer> queue = new PriorityQueue<>(k,(num1,num2)->{return num2 - num1;});
        for(int i = 0; i < k; i++){
            queue.offer(list.get(i));
        }
        for(int i = k + 1; i < list.size(); i++){
            if(queue.peek() > list.get(i)){
                queue.poll();
                queue.offer(list.get(i));
            }
        }
        while(!queue.isEmpty()){
            System.out.print(queue.poll() +  " ");
        }
    }

}
