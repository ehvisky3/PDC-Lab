public class TradeEvent
{
    protected String sender;
    protected long time;
    protected double price;

    public TradeEvent(String s, long t, double p)
    {
        sender = s;
        time = t;
        price = p;
    }

    public void dispatch()
    {
        System.out.println("Generic Event , Sender: " + sender
                + " , Time: " + time + " , Price: " + price);
    }
}