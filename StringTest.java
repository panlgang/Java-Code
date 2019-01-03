public class StringTest
{
    public static void main(String[] args) 
    {
        System.out.println(isAllNumber("12345abc"));
    }
    public static boolean isAllNumber(String str)
    {
        char[] arr = str.toCharArray();
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] > '9' || arr[i] < '0')
            {
                return false;
            }
        }
        return true;
    }
}
