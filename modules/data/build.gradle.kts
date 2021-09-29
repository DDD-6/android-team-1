plugins {
    `kotlin-jvm`
    `kotlin-kapt`
}

dependencies {
    implementation(project(Dependencies.Module.DOMAIN))

    implementation(Dependencies.HILT_CORE)
    kapt(Dependencies.HILT_COMPILER)

    implementation(Dependencies.COROUTINES_CORE)
}
