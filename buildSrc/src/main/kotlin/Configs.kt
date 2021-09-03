object Configs {
    //Plugins
    const val APPLICATION               = "com.android.application"
    const val LIBRARY                   = "com.android.library"
    const val KOTLIN_JVM                = "org.jetbrains.kotlin.jvm"
    const val KOTLIN                    = "kotlin"
    const val KOTLIN_ANDROID            = "kotlin-android"
    const val KOTLIN_KAPT               = "kotlin-kapt"
    const val NAVIGATION_ARGS           = "androidx.navigation.safeargs.kotlin"
    const val HILT                      = "dagger.hilt.android.plugin"
//    const val GOOGLE_SERVICE            = "com.google.gms.google-services"
//    const val FIREBASE_CRASHLYTICS      = "com.google.firebase.crashlytics"

    //Classpath
    object Project {
        const val GRADLE                = "com.android.tools.build:gradle:${Versions.GRADLE}"
        const val KOTLIN                = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val NAVIGATION            = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}"
        const val HILT                  = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
//        const val GOOGLE_SERVICE        = "com.google.gms:google-services:${Versions.GOOGLE_SERVICE}"
//        const val FIREBASE_CRASHLYTICS  = "com.google.firebase:firebase-crashlytics-gradle:${Versions.FIREBASE_CRASHLYTICS}"
    }

    //Android Config
    const val COMPILE_SDK               = 31

    //Android Default Config
    const val APPLICATION_ID            = "com.editor.appcha"
    const val MIN_SDK                   = 23
    const val TARGET_SDK                = 31
    const val VERSION_CODE              = 1
    const val VERSION_NAME              = "1.0.0"
}