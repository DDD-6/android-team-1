import Dependencies.Module

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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:1.1.5")
    
    implementation(project(Module.DOMAIN))
    implementation(project(Module.CORE_ARCH))

    implementation(Dependencies.ACTIVITY_COMPOSE)

    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_TOOLING)
    implementation(Dependencies.COMPOSE_FOUNDATION)
    implementation(Dependencies.COMPOSE_MATERIAL)
    implementation(Dependencies.COMPOSE_ACTIVITY)
    implementation(Dependencies.COMPOSE_VIEW_MODEL)
    implementation(Dependencies.COMPOSE_NAVIGATION)

    implementation(Dependencies.APPCOMPANIST_SYSTEM_UI_CONTROLLER)
    implementation(Dependencies.COIL_COMPOSE)

    implementation(Dependencies.LIFECYCLE_RUNTIME)

    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_COMPILER)
    implementation(Dependencies.HILT_NAVIGATION)

    implementation(Dependencies.COROUTINES_ANDROID)

    implementation(Dependencies.KAKAO_USER)

    testImplementation(Dependencies.JUNIT)
    testImplementation(Dependencies.TRUTH)
    testImplementation(Dependencies.MOCKK)
    testImplementation(Dependencies.COROUTINES_TEST)
}
