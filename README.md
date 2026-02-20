<!-- SPDX-FileCopyrightText: 2026 Mattia Egloff <mattia.egloff@pm.me> -->
<!-- SPDX-License-Identifier: GPL-3.0-or-later -->

# VauchiMobile Android Library

Android library distribution for VauchiMobile bindings.

## Installation

### Gradle (Kotlin DSL)

Add the GitLab Maven repository to your `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://gitlab.com/api/v4/projects/77955319/packages/maven")
        }
    }
}
```

Add the dependency to your `app/build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.vauchi:vauchi-mobile:0.1.0")
}
```

### Gradle (Groovy)

Add the repository to your `settings.gradle`:

```groovy
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven {
            url "https://gitlab.com/api/v4/projects/77955319/packages/maven"
        }
    }
}
```

Add the dependency to your `app/build.gradle`:

```groovy
dependencies {
    implementation 'com.vauchi:vauchi-mobile:0.1.0'
}
```

## Usage

```kotlin
import uniffi.vauchi_mobile.VauchiMobile

class MyActivity : AppCompatActivity() {
    private lateinit var vauchi: VauchiMobile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize with app storage
        val dbPath = filesDir.resolve("vauchi.db").absolutePath
        vauchi = VauchiMobile(storagePath = dbPath)

        // Create identity
        vauchi.createIdentity(password = "secure-password")

        // Get public ID for sharing
        val publicId = vauchi.getPublicId()
    }
}
```

## Requirements

- Android API 26+ (Android 8.0 Oreo)
- Kotlin 1.9+

## Architecture Support

The library includes native binaries for:
- `arm64-v8a` - 64-bit ARM (most modern devices)
- `x86_64` - 64-bit x86 (emulators)

## ProGuard

ProGuard rules are automatically included via `consumer-rules.pro`.

## License

GPL-3.0-or-later - see [LICENSE](LICENSE)

## Links

- [Main Repository](https://gitlab.com/vauchi/core)
- [Documentation](https://gitlab.com/vauchi/docs)
- [Issues](https://gitlab.com/vauchi/vauchi/-/issues)
