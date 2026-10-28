# Question 3 — Asynchronous Web Engine

## Compilation and Execution Test

### Source Files
- `TelemetryThread.java`
- `LogProcessorTask.java`
- `AsyncWebEngineApp.java`

### Compilation Command
```powershell
javac "Question #03\TelemetryThread.java" "Question #03\LogProcessorTask.java" "Question #03\AsyncWebEngineApp.java"
```

### Execution Command
```powershell
java -cp "Question #03" AsyncWebEngineApp
```

### Expected Result

The application starts two worker threads:
- **Telemetry worker:** prints five CPU and memory health updates, with an 800 ms delay between iterations.
- **Log worker:** prints five log metric iterations, with a 1067 ms delay between iterations.

The main thread also displays its name and the states of both worker threads. Output order and reported thread states may vary because execution is concurrent.

### Test Status

Compilation and execution were verified successfully. Both worker threads produced their expected updates.