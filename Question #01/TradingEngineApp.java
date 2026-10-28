public class TradingEngineApp
{
    public static void main(String[] a)
    {
        TradeEvent o = new FixOrderEvent("FIXGATEWAY", 17100001L, 167, "ORDER_67");
        TradeEvent q = new ReutersQuoteEvent("REUTERSFEED", 17100002L, 67, 67.5, 267.5);
        TradeEvent[] list = {o, q};

        for (int i = 0; i < list.length; i++)
            list[i].dispatch();
    }
}