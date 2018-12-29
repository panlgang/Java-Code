interface Buy 
{
    void buy();
}

class Real implements Buy
{
    public void buy()
    {
        System.out.println("付钱");
    }
}

class Proxy implements Buy
{
    private Buy b;
    public Proxy(Buy b)
    {
        this.b = b;
    }
    public void  beforeBuy()
    {
        System.out.println("排队等候");
    }
    public void buy()
    {
        this.beforeBuy();
        this.b.buy();
        this.afterBuy();
    }
    public void afterBuy()
    {
        System.out.println("快递给客户");
    }
}

public class TestProxy 
{
    public static void main(String[] args) 
    {
        Buy b = new Proxy(new Real());
        b.buy();
    }
}