import PropertyUtil.getKakaoApiNativeKey

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

        vectorDrawables {
            useSupportLibrary = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    implementation(project(Dependencies.Module.DOMAIN))
    implementation(project(Dependencies.Module.CORE_ARCH))
    implementation(project(Dependencies.Module.CORE_UI))
    implementation(project(Dependencies.Module.NAVIGATION))

    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.ACTIVITY_KTX)
    implementation(Dependencies.FRAGMENT_KTX)

    implementation(Dependencies.LIFECYCLE_VIEW_MODEL)
    implementation(Dependencies.LIFECYCLE_RUNTIME)

    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_COMPILER)

    implementation(Dependencies.COROUTINES_ANDROID)
}
