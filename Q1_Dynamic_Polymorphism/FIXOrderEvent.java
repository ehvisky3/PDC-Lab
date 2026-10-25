public class FIXOrderEvent extends TradeEvent {

    public FIXOrderEvent(String eventId, String symbol, double price) {
        super(eventId, symbol, price);
    }

    @Override
    public void processEvent() {
        System.out.println("Processing FIX order: " + symbol + " at price " + price);
    }

}