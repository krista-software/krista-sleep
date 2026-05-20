[comment]: <> (Home Page)

# Sleep Extension

## Overview

The **Sleep Extension** provides conversation pause functionality for Krista workflows, enabling controlled delays and timing management in conversation flows.

## Key Features

- ⏱️ **Flexible Timing** - Pause from milliseconds to hours with decimal precision
- 🔒 **Thread-Safe** - Safe for concurrent use in multiple conversations
- 🎯 **Simple Interface** - Single catalog request, easy to use
- 📝 **Detailed Logging** - Track sleep operations for debugging

## Quick Start

### Installation

The Sleep extension requires **no configuration** - it's ready to use immediately after installation.

### Usage

Add the "Conversation Sleep" catalog request to your workflow:

**Input:**
- **Seconds to Sleep**: Number of seconds to pause (supports decimals)

**Examples:**
```
2.5   → Pause for 2.5 seconds
1.0   → Pause for 1 second
0.5   → Pause for half a second
```

## Common Use Cases

| Use Case | Description | Example |
|----------|-------------|---------|
| **Rate Limiting** | Add delays between API calls | Sleep 1 second between requests |
| **User Experience** | Natural conversation flow | Sleep 0.5 seconds before response |
| **Synchronization** | Wait for external systems | Sleep 3 seconds for processing |
| **Polling** | Delay between status checks | Sleep 5 seconds between polls |
| **Testing** | Simulate processing time | Sleep 2 seconds in dev environment |

## Documentation

- [Overview](/pages/overview.md) - Extension capabilities and architecture
- [Conversation Sleep](/pages/supportedRequests.md) - Catalog request details
- [Release Notes](/pages/release-notes.md) - Version history

## Technical Details

**Version Information**
- Extension Version: 1.0.1
- Java Version: 21
- Ecosystem: Essentials
- Domain: Conversation Authoring

**Architecture**
```
Krista Platform
    ↓
SleepArea (Catalog Request)
    ↓
SleepService (Business Logic)
    ↓
Thread.sleep() (Java Core)
```

---

**Ready to use?** Just add the "Conversation Sleep" catalog request to your workflow!

