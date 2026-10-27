public class ReutersQuoteEvent extends TradeEvent {

    public ReutersQuoteEvent(String eventId, String symbol, double price) {
        super(eventId, symbol, price);
    }

    @Override
    public void processEvent() {
        System.out.println("Processing Reuters quote: " + symbol + " at price " + price);
    }

}