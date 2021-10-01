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
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    implementation(project(Dependencies.Module.UI_COMPOSE))
    implementation(project(Dependencies.Module.DOMAIN))
    implementation(project(Dependencies.Module.DATA))
    implementation(project(Dependencies.Module.REMOTE))
    implementation(project(Dependencies.Module.LOCAL))
    implementation(project(Dependencies.Module.CORE_ARCH))
    implementation(project(Dependencies.Module.CORE_UI))

    implementation(Dependencies.HILT)
    kapt(Dependencies.HILT_COMPILER)

    implementation(Dependencies.COROUTINES_CORE)
}
