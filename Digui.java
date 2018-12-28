public class Digui
{
   public static void main(String[] args) 
   {
      // int a = 24;
      // int b = 16;
      //int r = gcd(18,16);
     // System.out.println(r);
     //disnum(1234);
     System.out.println(sum2(1234));
   }
//    public static int sum2(int num)
//    {
//       int count = 1;
//       while(num > 10)
//       {
//          num /= 10;
//          count++;
//       }
//       return count;
//    }
// }
   public static int sum2(int num)
   {
      int count = 1;
      if(num < 10)
      {
         return count;
      }
      return count += sum2(num/10);
   }
}














//    public static int sum1(int num)
//    {
//       int sum = 0;
//       while(num != 0)
//       {
//          sum += num%10;
//          num /= 10;
//       }
//       return sum;
//    }
// }




















//    public static int sum(int num)
//    {
//       if(num < 10)
//       {
//          return num;
//       }
//       return num%10 + sum(num/10);
//    }
//    public static void disnum(int num)
//    {
//       if(num < 10)
//       {
//          System.out.print(num+" ");
//       }
//       else
//       {
//          disnum(num/10);
//          System.out.print(num%10+" ");
//       }
//    }
//    public static int gcd(int a,int b)
//    {
//       int r = a % b;
//       if(r == 0)
//          return b;
//       else
//          return gcd(b,r);
//    }
// }