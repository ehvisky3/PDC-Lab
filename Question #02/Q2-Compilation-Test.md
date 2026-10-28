# Question 2 — Packet Symmetry Auditor

## Compilation and Execution Test

### Source Files
- `TransactionStack.java`
- `RequestQueue.java`
- `PacketSymmetryAuditor.java`

### Compilation Command
```powershell
javac "Question #02\TransactionStack.java" "Question #02\RequestQueue.java" "Question #02\PacketSymmetryAuditor.java"
```

### Execution Command
```powershell
java -cp "Question #02" PacketSymmetryAuditor
```

### Expected Result

The program compares characters retrieved from a stack and a queue. For the packet `tacocat`, both sequences match, and the program reports:

`verified log: packet tacocat has bi-directional symmetry.`

### Test Status

Compilation and execution completed successfully. The output confirmed that the packet was identified as symmetrical.