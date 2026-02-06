package com.vauchi.mobile

/**
 * VauchiMobile - Android bindings for Vauchi
 *
 * This package provides Android bindings for the Vauchi library,
 * enabling privacy-focused contact card exchange on Android.
 *
 * The UniFFI-generated bindings are in the `uniffi.vauchi_mobile` package.
 *
 * Usage:
 * ```kotlin
 * import uniffi.vauchi_mobile.VauchiMobile
 *
 * val vauchi = VauchiMobile(storagePath = context.filesDir.resolve("vauchi.db").absolutePath)
 * vauchi.createIdentity(password = "secure-password")
 * val publicId = vauchi.getPublicId()
 * ```
 */
object VauchiMobileLib {
    /**
     * Library version
     */
    const val VERSION = "0.1.13"

    /**
     * Check if native library is loaded
     */
    val isLoaded: Boolean
        get() = try {
            System.loadLibrary("vauchi_mobile")
            true
        } catch (e: UnsatisfiedLinkError) {
            false
        }
}
