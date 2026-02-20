// SPDX-FileCopyrightText: 2026 Mattia Egloff <mattia.egloff@pm.me>
//
// SPDX-License-Identifier: GPL-3.0-or-later

// Top-level build file for VauchiMobile Android library

plugins {
    id("com.android.library") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("maven-publish")
}

group = "com.vauchi"
version = System.getenv("VERSION") ?: "0.1.0"
