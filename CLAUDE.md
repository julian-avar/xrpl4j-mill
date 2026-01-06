# Claude Development Notes

## Project Overview
This is xrpl4j, a Java library for working with the XRP Ledger, being migrated from Maven to Mill build system and gradually translating Java code to Scala 3.7.4.

## Build System
- **Build Tool**: Mill 1.1.0-RC3
- **Structure**: Multi-module project with package.mill files
- **Base Module**: `Xrpl4jMillBaseModule` in mill-build/src/

### Modules
- `xrpl4j-core`: Core library with models and Jackson serialization
- `xrpl4j-client`: API client
- `xrpl4j-bom`: Bill of materials
- `xrpl4j-integration-tests`: Integration tests

## Scala Migration Strategy

### Language Versions
- **Scala Version**: 3.7.4
- **Java Compatibility**: Targeting Java 1.8 for compatibility
- **JVM**: Zulu 11

### Module Type Choice
Using `mill.scalalib.SbtModule` instead of `mill.scalalib.ScalaModule` for compatibility reasons:
- SbtModule provides better Maven/SBT compatibility
- Follows standard src/main/scala and src/test/scala directory structure
- Easier interop with existing Java code

### Directory Structure
Java and Scala sources coexist:
```
xrpl4j-core/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/xrpl/xrpl4j/...
│   │   ├── scala/
│   │   │   └── org/xrpl/xrpl4j/...
│   │   └── resources/
│   └── test/
│       ├── java/
│       ├── scala/
│       └── resources/
```

## Key Dependencies
- Jackson 2.14.3 (JSON serialization)
- Guava 32.1.1-jre
- Immutables 2.9.3 (for value objects)
- Bouncy Castle (cryptography)
- SLF4J (logging)

## Build System Ignored Files
The following Mill/Scala-related directories are in .gitignore:
- `.bsp/` - Build Server Protocol
- `.metals/` - Scala language server metadata
- `.vscode/` - VS Code settings
- `out/` - Mill build output
- `.scalafmt.conf` - Scala formatting config (if generated)

## Migration Notes
- Translating Java to Scala incrementally
- Maintaining backwards compatibility
- Using Scala's interop features to work alongside existing Java code
- Jackson annotations and serializers need careful handling in Scala

## Development Commands
```bash
# Build all modules
./mill __.compile

# Run tests
./mill __.test

# Build specific module
./mill xrpl4j-core.compile

# Clean build
./mill clean
```

## Next Steps
1. Set up Scala module support in build files
2. Begin translating simple serializers/deserializers
3. Add Scala-specific tooling (scalafmt, etc.)
4. Gradually migrate more complex classes
