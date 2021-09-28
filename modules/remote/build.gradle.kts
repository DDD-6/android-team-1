plugins {
    `kotlin-jvm`
    `kotlin-kapt`
}

dependencies {
    implementation(project(Dependencies.Module.DATA))

    implementation(Dependencies.HILT_CORE)
    kapt(Dependencies.HILT_COMPILER)
    // TODO: GRPC
}
