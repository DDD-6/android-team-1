import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec

inline val PluginDependenciesSpec.`android-application` get() = id("com.android.application")
inline val PluginDependenciesSpec.`android-library` get() = id("com.android.library")

inline val PluginDependenciesSpec.`kotlin-jvm` get() = kotlin("jvm")
inline val PluginDependenciesSpec.`kotlin-android` get() = kotlin("android")
inline val PluginDependenciesSpec.`kotlin-kapt` get() = kotlin("kapt")

inline val PluginDependenciesSpec.`hilt-android` get() = id("dagger.hilt.android.plugin")
inline val PluginDependenciesSpec.`protobuf` get() = id("com.google.protobuf")

object Dependencies {
    //Module
    object Module {
        const val UI = ":ui"
        const val DOMAIN = ":domain"
        const val DATA = ":data"
        const val REMOTE = ":remote"
        const val LOCAL = ":local"

        const val CORE_ARCH = ":core-arch"
    }

    //Classpath
    object Project {
        const val GRADLE = "com.android.tools.build:gradle:${Versions.GRADLE}"
        const val KOTLIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val HILT = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
        const val PROTOBUF_GRADLE_PLUGIN =
            "com.google.protobuf:protobuf-gradle-plugin:${Versions.PROTOBUF_GRADLE_PLUGIN}"
    }

    //Android
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
    const val ACTIVITY_COMPOSE = "androidx.activity:activity-compose:${Versions.ACTIVITY_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    const val PREFERENCE_KTX = "androidx.preference:preference-ktx:${Versions.PREFERENCE_KTX}"
    const val STARTUP = "androidx.startup:startup-runtime:${Versions.STARTUP}"

    //Jetpack Compose
    const val COMPOSE_UI = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val COMPOSE_TOOLING = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val COMPOSE_FOUNDATION = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose:${Versions.COMPOSE_ACTIVITY}"
    const val COMPOSE_VIEW_MODEL =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.COMPOSE_VIEW_MODEL}"
    const val COMPOSE_NAVIGATION =
        "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION}"
    const val COMPOSE_CONSTRAINT_LAYOUT =
        "androidx.constraintlayout:constraintlayout-compose:${Versions.COMPOSE_CONSTRAINT_LAYOUT}"

    const val APPCOMPANIST_SYSTEM_UI_CONTROLLER =
        "com.google.accompanist:accompanist-systemuicontroller:${Versions.APPCOMPANIST}"
    const val APPCOMPANIST_INSETS =
        "com.google.accompanist:accompanist-insets:${Versions.APPCOMPANIST}"

    const val COIL_COMPOSE = "io.coil-kt:coil-compose:${Versions.COIL}"

    const val LOTTIE_COMPOSE = "com.airbnb.android:lottie-compose:${Versions.LOTTIE}"

    //Dependency Injection
    const val HILT = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_CORE = "com.google.dagger:hilt-core:${Versions.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    const val HILT_NAVIGATION = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"

    //Coroutines
    const val COROUTINES_CORE =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    const val COROUTINES_TEST =
        "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"

    //Kakao
    const val KAKAO_USER = "com.kakao.sdk:v2-user:${Versions.KAKAO}"

    //Lifecycle Component
    const val LIFECYCLE_VIEW_MODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"

    //GRPC
    const val GRPC_OKHTTP = "io.grpc:grpc-okhttp:${Versions.GRPC}"
    const val GRPC_STUB = "io.grpc:grpc-stub:${Versions.GRPC}"
    const val GRPC_API = "io.grpc:grpc-api:${Versions.GRPC}"
    const val GRPC_PROTOBUF_LITE = "io.grpc:grpc-protobuf-lite:${Versions.GRPC}"
    const val GRPC_KOTLIN_STUB = "io.grpc:grpc-kotlin-stub:${Versions.GRPC_KOTLIN}"

    //Protobuf
    const val PROTOBUF_JAVALITE = "com.google.protobuf:protobuf-javalite:${Versions.PROTOBUF}"

    const val JUNIT = "junit:junit:4.13.2"
    const val TRUTH = "com.google.truth:truth:1.1.3"
    const val MOCKK = "io.mockk:mockk:1.12.0"
}
