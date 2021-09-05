plugins {
    `kotlin-jvm`
}

dependencies {
    implementation(project(Dependencies.Module.DOMAIN))

    implementation(Dependencies.INJECT)
    implementation(Dependencies.COROUTINES_CORE)
}
