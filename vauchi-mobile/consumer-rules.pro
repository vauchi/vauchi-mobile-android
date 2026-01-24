# Consumer ProGuard rules for VauchiMobile
# These rules are automatically included when the library is used

# Keep UniFFI generated classes
-keep class uniffi.vauchi_mobile.** { *; }

# Keep JNA classes
-dontwarn com.sun.jna.**
-keep class com.sun.jna.** { *; }
