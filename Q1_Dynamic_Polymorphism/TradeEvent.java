public class TradeEvent {

    protected String eventId;
    protected String symbol;
    protected double price;

    public TradeEvent(String eventId, String symbol, double price) {
        this.eventId = eventId;
        this.symbol = symbol;
        this.price = price;
    }

    public void processEvent() {
        System.out.println("Processing generic trade event: " + eventId);
    }

}