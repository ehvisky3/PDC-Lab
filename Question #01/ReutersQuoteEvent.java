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

    @Override
    public void dispatch()
    {
        double spread = ask - bid;
        System.out.println("Reuters Quote | Sender: " + sender
                + " | Bid: " + bid
                + " | Ask: " + ask
                + " | Spread: " + spread);
    }
}