public class ReutersQuoteEvent extends TradeEvent {

    public ReutersQuoteEvent(String eventId, String symbol, double price) {
        super(eventId, symbol, price);
    }

}