plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
    `hilt-android`
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
    implementation(project(Dependencies.Module.DATA))

    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_COMPILER)

    implementation(Dependencies.COROUTINES_CORE)
}
