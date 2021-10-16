plugins {
    `android-library`
    `kotlin-android`
}

android {
    compileSdk = Configs.COMPILE_SDK

    defaultConfig {
        minSdk = Configs.MIN_SDK
        targetSdk = Configs.TARGET_SDK
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.LIFECYCLE_VIEW_MODEL)
    implementation(Dependencies.COROUTINES_ANDROID)

    implementation(Dependencies.MATERIAL)
}

