public class FixOrderEvent extends TradeEvent
{
    private String id;

    public FixOrderEvent(String s, long t, double p, String i)
    {
        super(s, t, p);
        id = i;
    }
}