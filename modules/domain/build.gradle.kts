plugins {
    `kotlin-jvm`
}

dependencies {
    implementation(project(Dependencies.Module.CORE_ARCH))

    implementation(Dependencies.HILT_CORE)
    implementation(Dependencies.COROUTINES_CORE)
}
