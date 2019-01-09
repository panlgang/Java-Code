package www.test.java;

public class Test {
    public static void main(String[] args) {
        String str = "A2B5E34FG0ZYWPQ59R@";
        System.out.println(codeTranslate(str));
    }
    public static String codeTranslate(String str) {
        char[] arr = str.toCharArray();
        int i = 0;
        int tmp = 0;
        String ret = "" + arr[0];
        while (arr[i] != '@' && (i + 2 < arr.length)) {
            if ('0' <= arr[i + 1] && arr[i + 1] <= '9') {
                tmp = arr[i + 1] - '0';
                for (int j = 0; j <= tmp; j++) {
                    ret += arr[i + 2];
                }
                i+=2;
            } else {
                ret += arr[i];
                i++;
            }

        }
        return ret;
    }
}
