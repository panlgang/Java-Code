class CompleteNumber
{
    public static void main(String[] args) 
    {
        int i = 1;
        while(i < 1000)
        {
            if(fun(i) == true)
            {
                System.out.print(i + "、");
            }
            i++;
        }  
    }
    public static boolean fun(int num)
    {
        int sum = 0;
        for(int i = 1 ; i <= num / 2 ; i++)
        {
            if(num % i == 0)
            {
                sum += i;
            }
        }
        if(sum == num)
        {
            return true ;
        }
        return false;

    }
}