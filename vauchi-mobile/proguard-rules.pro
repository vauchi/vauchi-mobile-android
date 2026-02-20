# SPDX-FileCopyrightText: 2026 Mattia Egloff <mattia.egloff@pm.me>
#
# SPDX-License-Identifier: GPL-3.0-or-later

# ProGuard rules for VauchiMobile

# Keep UniFFI generated classes
-keep class uniffi.vauchi_mobile.** { *; }

# Keep JNA classes used by UniFFI
-keep class com.sun.jna.** { *; }
-keepclassmembers class * extends com.sun.jna.** { *; }

# Keep native method names
-keepclasseswithmembernames class * {
    native <methods>;
}
