[<span style = "color : blue ; text-decoration: none">< Back</span>](/)

# Release Notes - Sleep Extension

---

## Version 1.0.2 - Current Release

**Developer**: Ramgopal Patidar
**Krista Service APIs (Java)**: 1.0.117

### What's New

#### Service-Oriented Architecture
- **Refactored to Service Layer**: Extracted business logic into `SleepService` for better separation of concerns
- **Dependency Injection**: Implemented HK2-based dependency injection for clean architecture
- **Improved Testability**: Service layer enables comprehensive unit testing

#### Comprehensive Test Coverage
- **7 Unit Tests**: Complete test coverage for all scenarios
- **Service Tests**: Timing validation, interrupt handling, edge cases
- **Integration Tests**: End-to-end testing with real service
- **Mockito Integration**: Proper mocking for isolated unit tests

#### Build System Modernization
- **Modern Gradle**: Updated to Gradle 8.x with plugin DSL
- **Dynamic Versioning**: Automatic version extraction from annotations
- **Release Properties**: Automated metadata generation
- **Direct Dependencies**: Explicit Maven coordinates for all dependencies

### Features

- **Conversation Sleep**: Pause conversations for specified durations
- **Decimal Precision**: Support for fractional seconds (e.g., 2.5 seconds)
- **Thread-Safe**: Safe for concurrent use in multiple conversations
- **Error Handling**: Proper interrupt handling with detailed logging
- **Zero Configuration**: Ready to use immediately after installation

### Technical Details

- **Java Version**: 21
- **Ecosystem**: Essentials
- **Domain**: Conversation Authoring
- **Request Type**: CHANGE_SYSTEM
- **Architecture**: Service-oriented with dependency injection

### Dependencies

- Krista APIs: 1.0.117
- HK2 API: 3.0.3
- SLF4J: 2.0.9
- Apache Commons IO: 2.11.0
- Apache Commons Lang3: 3.12.0
- JUnit Jupiter: 5.8.1
- Mockito: 4.11.0

### Documentation

- Complete README with quick start guide
- Detailed catalog request documentation
- Architecture overview
- Use case examples
- Best practices guide

---

## Version 1.0.0 - Initial Release

**Release Date**: 2024

### Features

- **Conversation Sleep**: Basic sleep functionality
- **Simple Interface**: Single catalog request
- **Logging**: Basic logging support

### Technical Details

- **Java Version**: 21
- **Basic Implementation**: Direct sleep in catalog request handler

---

*Last Updated: November 2025*

