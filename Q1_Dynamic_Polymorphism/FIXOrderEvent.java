public class FIXOrderEvent extends TradeEvent {

    public FIXOrderEvent(String eventId, String symbol, double price) {
        super(eventId, symbol, price);
    }

}