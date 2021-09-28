plugins {
    `kotlin-jvm`
}

dependencies {
    implementation(project(Dependencies.Module.DATA))

    implementation(Dependencies.HILT_CORE)

    // TODO: GRPC
}
