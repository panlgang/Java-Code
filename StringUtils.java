public class StringUtils
{

    public static void main(String[] args) 
    {
        System.out.println(repeat('c', 10));
        System.out.println(fillBefore("hello", 'A', 10));
        System.out.println(fillAfter("hello", 'A', 10));
        System.out.println(removeAll("aa-bb-cc-dd", "-"));
        System.out.println(reverse("hello"));
        System.out.println(myTrim("  hello   "));
        System.out.println(myTrim("     2"));
        System.out.println(reverse("abcdefg",2,5));
        System.out.println(getMaxSubstring("abdabcdefabgh","abcdhhge"));
        System.out.println("a");
    }

    public static  String getMaxSubstring(String str1,String str2)
    {
        String maxStr = (str1.length() > str2.length()) ? str1 : str2;
        String minStr = (str1.length() < str2.length()) ? str1 : str2;
        int len = minStr.length();
        for(int i = 0; i < len; i++)
        {
            for(int x = 0, y = len -i;y <= len ; x++,y++)
            {
                if(maxStr.contains(minStr.substring(x,y)) == true)
                {
                    return minStr.substring(x,y);
                }
            }
        }
        return null;
    }


    public static String myTrim(String str)
    {
        int start = 0;
        int end = str.length() - 1;
        while(start < end  && str.charAt(start) == ' ')
        {
            start++;
        }
        while(start < end  && str.charAt(end) ==' ')
        {
            end--;
        }
        return str.substring(start , end+1); 
    }

    public static int getTime(String str1, String str2)
    {
        int count = 0;
        while(str1.indexOf(str2) != -1)
        {
            count++;
            str1 = str1.substring(str2.length() + str1.indexOf(str2));
        }
        return count;
    }

    public static String repeat(char c, int count) 
    {
       if(count <= 0)
       {
          return "";
       }
       return c + repeat(c, count - 1);   
    }

    public static String fillBefore(String str, char filledChar, int len) 
    {
        if(str.length() < len)
        {
            return filledChar + fillBefore(str, filledChar, len-1);
        }
        return str;
     }

     public static String fillAfter(String str, char filledChar, int len)
     {
         if(str.length() < len)
         {
             return fillAfter( str,  filledChar,  len-1) + filledChar;
         }
         return str;
     } 

     public static String removeAll(String str, String strToRemove) 
     {
          String[] arr = str.split(strToRemove);
          String ret ="";
          for(int i = 0; i < arr.length; i++)
          {
                ret += arr[i];
          }
          return ret;
     }

    public static String reverse (String str, int start, int end)
    {
        String ret = str.substring(0,start);
        for(int i = end; i >= start; i--)
        {
             ret += str.charAt(i);
        }
        return  ret + str.substring(end+1);
    }

    public static String reverse(String str) 
    {
        char[] arr = str.toCharArray();
        int len = arr.length;
        int j = 0,i = 0;
        for(i = 0, j = len -1 ; i < j; i++, j--)
        {
            if(arr[i] != arr[j])
            {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        return new String(arr);
    }

    public static String firstUpper(String str)
    {
        if(str == null || str.isEmpty())
        {
            return str;
        }
        if(str.length() > 1)
        {
            return str.substring(0,1).toUpperCase() + str.substring(1);
        }
        return str.toUpperCase();
       
    }

   

}