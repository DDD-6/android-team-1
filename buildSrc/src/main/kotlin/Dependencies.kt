import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec

inline val PluginDependenciesSpec.`android-application` get() = id("com.android.application")
inline val PluginDependenciesSpec.`android-library` get() = id("com.android.library")

inline val PluginDependenciesSpec.`kotlin-jvm` get() = kotlin("jvm")
inline val PluginDependenciesSpec.`kotlin-android` get() = kotlin("android")
inline val PluginDependenciesSpec.`kotlin-kapt` get() = kotlin("kapt")

inline val PluginDependenciesSpec.`navigation-args` get() = id("androidx.navigation.safeargs.kotlin")
inline val PluginDependenciesSpec.`hilt-android` get() = id("dagger.hilt.android.plugin")

object Dependencies {
    //Module
    object Module {
        const val UI                        = ":ui"
        const val DOMAIN                    = ":domain"
        const val DATA                      = ":data"
        const val REMOTE                    = ":remote"
        const val LOCAL                     = ":local"

        const val CORE_ARCH                 = ":core-arch"
        const val CORE_UI                   = ":core-ui"
    }

    //Classpath
    object Project {
        const val GRADLE                = "com.android.tools.build:gradle:${Versions.GRADLE}"
        const val KOTLIN                = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
        const val NAVIGATION            = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.NAVIGATION}"
        const val HILT                  = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
    }

    //Android
    const val CORE_KTX                  = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APPCOMPAT                 = "androidx.appcompat:appcompat:${Versions.APPCOMPAT}"
    const val MATERIAL                  = "com.google.android.material:material:${Versions.MATERIAL}"
    const val ACTIVITY_KTX              = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
    const val FRAGMENT_KTX              = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"

    //Jetpack Compose
    const val COMPOSE_UI                = "androidx.compose.ui:ui:${Versions.COMPOSE}"
    const val COMPOSE_TOOLING           = "androidx.compose.ui:ui-tooling:${Versions.COMPOSE}"
    const val COMPOSE_FOUNDATION        = "androidx.compose.foundation:foundation:${Versions.COMPOSE}"
    const val COMPOSE_MATERIAL          = "androidx.compose.material:material:${Versions.COMPOSE}"
    const val COMPOSE_ACTIVITY          = "androidx.activity:activity-compose:${Versions.COMPOSE_ACTIVITY}"
    const val COMPOSE_VIEWMODEL         = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.COMPOSE_VIEWMODEL}"

    //Glide
    const val GLIDE                     = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    const val GLIDE_COMPILER            = "com.github.bumptech.glide:compiler:${Versions.GLIDE}"

    //Dependency Injection
    const val HILT                      = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_COMPILER             = "com.google.dagger:hilt-android-compiler:${Versions.HILT}"
    //Inject
    const val INJECT                    = "javax.inject:javax.inject:${Versions.INJECT}"

    //Navigation Component
    const val NAVIGATION_FRAGMENT       = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI             = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"

    //Coroutines
    const val COROUTINES_CORE           = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
    const val COROUTINES_ANDROID        = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"

    //Lifecycle Component
    const val LIFECYCLE_VIEWMODEL       = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_LIVEDATA        = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_COMPILER        = "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE}"
    const val LIFECYCLE_RUNTIME        = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFECYCLE}"
}
