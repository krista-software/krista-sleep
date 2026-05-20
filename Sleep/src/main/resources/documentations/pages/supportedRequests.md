[<span style = "color : blue ; text-decoration: none">< Back</span>](/)

# Supported Requests

## Catalog Requests

The Sleep Extension provides **1 catalog request** for conversation flow control:

---

## Conversation Sleep

### Overview

Pauses conversation execution for a specified duration, enabling controlled delays in workflow execution.

### Request Details

**Request Name**: `Conversation Sleep`

**Request Type**: `CHANGE_SYSTEM`

**Area**: `Sleep`

### Input Parameters

| Parameter | Type | Required | Description | Example |
|-----------|------|----------|-------------|---------|
| `secondsToSleep` | Double | Yes | Number of seconds to pause (supports decimals) | `2.5` |

### Output

This request does not return any output. It simply pauses execution for the specified duration.

### Behavior

1. Accepts the number of seconds to sleep as input
2. Converts seconds to milliseconds (seconds × 1000)
3. Calls `Thread.sleep()` to pause execution
4. Logs the sleep operation (start and end)
5. Handles interruptions by throwing `RuntimeException`

### Examples

#### Example 1: Pause for 2.5 seconds
```
Input:
  secondsToSleep: 2.5

Behavior:
  - Pauses for 2500 milliseconds
  - Logs: "conversationSleep() about to sleep for 2500 milliseconds"
  - Sleeps for 2.5 seconds
  - Logs: "conversationSleep() awake after 2500 milliseconds"
```

#### Example 2: Pause for 1 second
```
Input:
  secondsToSleep: 1.0

Behavior:
  - Pauses for 1000 milliseconds
```

#### Example 3: Pause for half a second
```
Input:
  secondsToSleep: 0.5

Behavior:
  - Pauses for 500 milliseconds
```

#### Example 4: No pause (edge case)
```
Input:
  secondsToSleep: 0

Behavior:
  - Pauses for 0 milliseconds (effectively no pause)
```

### Error Handling

**Thread Interruption:**
- If the sleep is interrupted, a `RuntimeException` is thrown
- The interruption is logged with full stack trace
- The original `InterruptedException` is wrapped in the `RuntimeException`

**Example Error:**
```
Error: Thread interrupted during sleep
Cause: InterruptedException
Resolution: Check logs for interruption source
```

### Technical Details

**Implementation:**
- Service: `SleepService`
- Method: `sleep(Double secondsToSleep)`
- Thread Safety: Yes (uses `Thread.sleep()`)
- Logging: SLF4J with detailed start/end messages

**Precision:**
- Millisecond precision (1/1000 of a second)
- Actual sleep time may vary slightly based on system scheduling

### Best Practices

1. **Use Appropriate Durations**
   - Short delays (0.5-2s) for UX improvements
   - Medium delays (2-5s) for external system sync
   - Longer delays (5-30s) for polling operations

2. **Consider Alternatives**
   - For very short delays (<100ms), consider if sleep is necessary
   - For very long delays (>60s), consider using scheduled tasks instead

3. **Error Handling**
   - Wrap sleep calls in try-catch if interruption is expected
   - Log sleep operations for debugging timing issues

4. **Testing**
   - Use shorter durations in test environments
   - Consider mocking sleep in unit tests

### Logging

The request logs the following information:

**Start of Sleep:**
```
INFO: conversationSleep() about to sleep for {milliseconds} milliseconds
```

**End of Sleep:**
```
INFO: conversationSleep() awake after {milliseconds} milliseconds
```

**Error:**
```
ERROR: {error message}
{stack trace}
```

---

## Quick Reference

| Request Name | Type | Input | Output | Primary Use Case |
|--------------|------|-------|--------|------------------|
| Conversation Sleep | CHANGE | Seconds (Double) | None | Pause conversation flow |

---

**Need more details?** Check the [Overview](/pages/overview.md) for architecture and use case examples.
