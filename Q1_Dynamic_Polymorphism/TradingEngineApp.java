public class TradingEngineApp {

    public static void main(String[] args) {

        TradeEvent fixOrder = new FIXOrderEvent("FIX001", "AAPL", 195.50);
        TradeEvent reutersQuote = new ReutersQuoteEvent("RT001", "MSFT", 420.75);

        fixOrder.processEvent();
        reutersQuote.processEvent();

    }

}