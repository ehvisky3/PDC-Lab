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
}