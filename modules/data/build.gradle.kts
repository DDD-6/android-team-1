plugins {
    `kotlin-jvm`
}

dependencies {
    implementation(project(Dependencies.Module.DOMAIN))

    implementation(Dependencies.HILT_CORE)

    implementation(Dependencies.COROUTINES_CORE)
}
