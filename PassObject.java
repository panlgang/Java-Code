class Circle
{
    private double r;
    public double getArea()
    {
       return Math.PI * r * r;
    }
    public void  setRadious(int r)
    {
        this.r = r;
    }
}
public class PassObject
{
    public static void main(String[]args)
    {
        Circle circle = new Circle();
        double time = 5.0;
        int i = 0;
        for(i = 1; i <= time; i++)
        {
            circle.setRadious(i);   
            printArea(circle,i); 
        }
        System.out.println(i);
    }
    public static void printArea(Circle c,double time)
    {
        System.out.println(time + "     " + c.getArea());
    }
}