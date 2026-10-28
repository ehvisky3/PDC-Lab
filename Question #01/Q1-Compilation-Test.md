# Question 1 — Compilation and Execution Test

## Compilation

Command used:

```powershell
javac "Question #01\TradeEvent.java" "Question #01\FixOrderEvent.java" "Question #01\ReutersQuoteEvent.java" "Question #01\TradingEngineApp.java"
```

**Result:** Successful compilation with no errors.

## Execution

Command used:

```powershell
java -cp "Question #01" TradingEngineApp
```

## Verified output

```text
Fix Order | Order ID= ORDER_67 | Sender: FIXGATEWAY | Base Price= 167.0 | Fee = 1.1189 | Total= 168.1189
Reuters Quote | Sender: REUTERSFEED | Bid: 67.5 | Ask: 267.5 | Spread: 200.0
```

## Concepts verified

- Inheritance
- Method overriding
- Runtime polymorphism
- FIX order fee and total calculation
- Reuters bid-ask spread calculation
