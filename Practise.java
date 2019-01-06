
public class Practice {
    public static void main(String[] args) {

    }
    public static char fun(String str) {
        if (str == null || str.isEmpty()) {
            return '\u0000';
        }
        int sum = 0;
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] >= 'A' && arr[i] <= 'z') {
                    if (arr[i] == arr[j]) {
                        sum++;
                    }
                }
                if (sum >= 3) {
                    return arr[i];
                }
            }
        }
        return '\u0000';
    }

    public static String PartReverse(String str, int start, int end) {
        if(str == null || str.isEmpty()) {
            return "";
        }
        String ret = str.substring(0,start);
        for(int i = end; i >= start; i--) {
            ret += str.charAt(i);
        }
        return ret + str.substring(end+1);

    }
    public static boolean isHappy(int num) {
        if(num < 0) {
            return false;
        }
        while(true) {
            int sum = 0;
            while (num != 0) {
                sum += (num % 10) * (num % 10);
                num /= 10;
            }
            if (4 == sum) {
                return false;
            }
            if(1 == sum) {
                return true;
            }
            else return isHappy(sum);
        }


    }
}