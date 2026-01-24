plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

val libVersion: String = System.getenv("VERSION") ?: "0.1.0"

android {
    namespace = "com.vauchi.mobile"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    // JNI libraries are bundled in src/main/jniLibs/
    sourceSets {
        getByName("main") {
            jniLibs.srcDir("src/main/jniLibs")
        }
    }

    publishing {
        singleVariant("release") {
            withSourcesJar()
        }
    }
}

dependencies {
    // UniFFI runtime dependencies
    implementation("net.java.dev.jna:jna:5.14.0@aar")

    // Kotlin coroutines for async operations
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.vauchi"
            artifactId = "vauchi-mobile"
            version = libVersion

            afterEvaluate {
                from(components["release"])
            }

            pom {
                name.set("VauchiMobile")
                description.set("Android bindings for Vauchi - privacy-focused contact card exchange")
                url.set("https://gitlab.com/vauchi/vauchi-mobile-android")

                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }

                developers {
                    developer {
                        id.set("vauchi")
                        name.set("Vauchi Contributors")
                    }
                }

                scm {
                    connection.set("scm:git:git://gitlab.com/vauchi/vauchi-mobile-android.git")
                    developerConnection.set("scm:git:ssh://gitlab.com/vauchi/vauchi-mobile-android.git")
                    url.set("https://gitlab.com/vauchi/vauchi-mobile-android")
                }
            }
        }
    }

    repositories {
        maven {
            name = "GitLab"
            url = uri(System.getenv("CI_API_V4_URL")?.let { "$it/projects/${System.getenv("CI_PROJECT_ID")}/packages/maven" }
                ?: "https://gitlab.com/api/v4/projects/77955319/packages/maven")

            credentials(HttpHeaderCredentials::class) {
                name = if (System.getenv("CI_JOB_TOKEN") != null) "Job-Token" else "Private-Token"
                value = System.getenv("CI_JOB_TOKEN") ?: System.getenv("GITLAB_TOKEN") ?: ""
            }

            authentication {
                create<HttpHeaderAuthentication>("header")
            }
        }
    }
}
