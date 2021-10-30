import PropertyUtil.getKakaoApiNativeKey

plugins {
    `android-application`
    `kotlin-android`
    `kotlin-kapt`
    `hilt-android`
}

android {
    compileSdk = Configs.COMPILE_SDK

    defaultConfig {
        applicationId = Configs.APPLICATION_ID
        minSdk = Configs.MIN_SDK
        targetSdk = Configs.TARGET_SDK
        versionCode = Configs.VERSION_CODE
        versionName = Configs.VERSION_NAME

        manifestPlaceholders["kakao_api_native_key"] = getKakaoApiNativeKey()
        buildConfigField("String", "KAKAO_API_NATIVE_KEY", getKakaoApiNativeKey())
    }

    signingConfigs {
        getByName("debug") {
            storeFile = file("$rootDir/keystore/debug/debug.keystore")
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("debug") {
            isDebuggable = true
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    implementation(project(Dependencies.Module.UI))
    implementation(project(Dependencies.Module.REMOTE))

    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_COMPILER)

    implementation(Dependencies.COROUTINES_CORE)
    implementation(Dependencies.KAKAO_USER)

    implementation(Dependencies.GRPC_API)
    implementation(Dependencies.PREFERENCE)

    implementation(Dependencies.MATERIAL)
}
