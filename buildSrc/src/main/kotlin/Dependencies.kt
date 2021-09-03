object Dependencies {
    //Module
    object Module {
        const val DOMAIN                    = ":domain"
        const val DATA                      = ":data"
        const val REMOTE                    = ":remote"
        const val LOCAL                     = ":local"
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
    const val COMPOSE_NAVIGATION        = "androidx.navigation:navigation-compose:${Versions.COMPOSE_NAVIGATION}"
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
    const val COROUTINES                = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"

    //Lifecycle Component
    const val LIFECYCLE_VIEWMODEL       = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_LIVEDATA        = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFECYCLE}"
    const val LIFECYCLE_COMPILER        = "androidx.lifecycle:lifecycle-compiler:${Versions.LIFECYCLE}"

    //Room
    const val ROOM                      = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_KTX                  = "androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_COMPILER             = "androidx.room:room-compiler:${Versions.ROOM}"

    //Firebase
//    const val FIREBASE                  = "com.google.firebase:firebase-bom:${Versions.FIREBASE}"
//    const val FIREBASE_ANALYTICS        = "com.google.firebase:firebase-analytics-ktx"
//    const val FIREBASE_CRASHLYTICS      = "com.google.firebase:firebase-crashlytics-ktx"
}