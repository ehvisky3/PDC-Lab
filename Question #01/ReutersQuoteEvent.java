public class ReutersQuoteEvent extends TradeEvent
{
    private double bid;
    private double ask;

    public ReutersQuoteEvent(String s, long t, double p, double b, double a)
    {
        super(s, t, p);
        bid = b;
        ask = a;
    }
}
