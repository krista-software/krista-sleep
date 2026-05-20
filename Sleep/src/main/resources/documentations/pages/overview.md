[<span style = "color : blue ; text-decoration: none">< Back</span>](/)

# Sleep Extension - Overview

## What is the Sleep Extension?

The Sleep Extension is a simple utility extension for Krista that provides conversation pause functionality. It allows you to introduce controlled delays in your conversation workflows for timing, synchronization, and user experience purposes.

## What Does This Extension Do?

The Sleep Extension pauses conversation execution for a specified duration, enabling you to:
- Control the timing of conversation flows
- Add delays between operations
- Synchronize with external systems
- Improve user experience with natural pacing
- Implement rate limiting and polling strategies

## Available Catalog Requests

This extension provides **1 catalog request**:

### ⏱️ Conversation Sleep

**Purpose**: Pause a conversation for a specified number of seconds

**Input:**
- `secondsToSleep` (Double) - Number of seconds to pause (supports decimals)

**Examples:**
- `2.5` - Pause for 2.5 seconds
- `1.0` - Pause for 1 second
- `0.5` - Pause for half a second
- `5.0` - Pause for 5 seconds

**Use Cases:**
- Rate limiting between API calls
- Natural conversation pacing
- Waiting for external processing
- Polling delays
- Testing and simulation

## Key Capabilities

### Flexible Timing
- Support for decimal seconds (e.g., 2.5 seconds)
- No maximum duration limit
- Millisecond precision
- Zero-second sleep support for conditional logic

### Reliable Operation
- Thread-safe implementation
- Proper interrupt handling
- Comprehensive error handling
- Detailed logging for debugging

### Simple Integration
- No configuration required
- Single catalog request
- Intuitive interface
- Works immediately after installation

## Architecture

The extension follows a clean service-oriented architecture:

```
┌─────────────────────────────────────────┐
│         Krista Platform                 │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│      SleepArea                          │
│  (Catalog Request Handler)              │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│      SleepService                       │
│  (Business Logic & Error Handling)      │
└─────────────────┬───────────────────────┘
                  │
┌─────────────────▼───────────────────────┐
│      Thread.sleep()                     │
│  (Java Core Threading)                  │
└─────────────────────────────────────────┘
```

**Components:**
- **SleepArea**: Handles the catalog request and delegates to the service
- **SleepService**: Contains the core sleep logic with proper error handling
- **Dependency Injection**: Uses HK2 for clean dependency management

## Common Use Cases

### 1. Rate Limiting
Add delays between API calls to respect rate limits:
```
Call API
→ Sleep 1 second
→ Call API again
```

### 2. User Experience
Create natural conversation flow:
```
Show typing indicator
→ Sleep 0.5 seconds
→ Display response
```

### 3. External System Synchronization
Wait for external systems to process:
```
Submit request
→ Sleep 3 seconds
→ Check status
```

### 4. Polling
Implement polling with delays:
```
Check status
→ If not complete: Sleep 5 seconds
→ Check status again
```

### 5. Testing
Simulate processing time in development:
```
Start process
→ Sleep 2 seconds (simulate work)
→ Return result
```

## Technical Details

**Extension Information:**
- **Name**: Sleep
- **Version**: 1.0.1
- **Ecosystem**: Essentials
- **Domain**: Conversation Authoring
- **Java Version**: 21

**Dependencies:**
- Krista APIs (1.0.117)
- HK2 Dependency Injection (3.0.3)
- SLF4J Logging (2.0.9)
- Apache Commons (IO & Lang3)

**Testing:**
- 7 unit tests covering all scenarios
- Service layer tests with timing validation
- Catalog request tests with mocking
- Interrupt handling tests
- Integration tests

## Getting Started

1. **Install the Extension** - No configuration needed
2. **Add to Workflow** - Use the "Conversation Sleep" catalog request
3. **Specify Duration** - Enter the number of seconds to pause
4. **Test** - Verify the timing in your workflow

## Support & Resources

- [Supported Requests](/pages/supportedRequests.md) - Detailed catalog request documentation
- [Release Notes](/pages/release-notes.md) - Version history and updates

---

**Ready to use?** Just add the "Conversation Sleep" catalog request to your workflow!
