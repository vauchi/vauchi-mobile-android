# VauchiMobile Android v0.1.1

UniFFI bindings for Vauchi Android apps.

## Contents

- `jniLibs/` - Native libraries per ABI
  - `arm64-v8a/` - ARM64 (most modern devices)
  - `x86_64/` - x86_64 (emulators)
- `kotlin/uniffi/vauchi_mobile/` - Kotlin bindings

## Integration

### Gradle (from Maven repository)

```kotlin
// settings.gradle.kts
dependencyResolutionManagement {
    repositories {
        maven {
            url = uri("https://gitlab.com/api/v4/projects/vauchi%2Fvauchi-mobile-android/packages/maven")
        }
    }
}

// app/build.gradle.kts
dependencies {
    implementation("com.vauchi:vauchi-mobile:0.1.1")
}
```

### Manual Integration

1. Copy `jniLibs/` contents to `app/src/main/jniLibs/`
2. Copy `kotlin/uniffi/` to `app/src/main/kotlin/uniffi/`
3. Add to build.gradle.kts:
   ```kotlin
   android {
       sourceSets {
           getByName("main") {
               jniLibs.srcDir("src/main/jniLibs")
           }
       }
   }
   ```
4. Import and use: `import uniffi.vauchi_mobile.*`

## ABI Support

| ABI | Description | Support |
|-----|-------------|---------|
| arm64-v8a | 64-bit ARM | Primary |
| x86_64 | 64-bit x86 | Emulator |

## License

MIT License - see https://gitlab.com/vauchi/core
