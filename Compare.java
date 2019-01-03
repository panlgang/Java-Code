public class Compare
{
    public static void main(String[] args) 
    {
        String str1 = new String("abdef");
        String str2 = new String("abD");
        System.out.println(compareTo(str1,str2));
    }
    public static int compareTo (String str1, String str2)
    {
        if(str1 == str2)
        {
            return 0;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int len = arr1.length < arr2.length ? arr1.length : arr2.length;
        int i = 0;
        while(i < len)
        {
            if(arr1[i] == arr2[i])
            {
                i++;
            }
            else
            {
                return arr1[i] - arr2[i];
            }
            
        }
        return arr1.length - arr2.length;

    }
}