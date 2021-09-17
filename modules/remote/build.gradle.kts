plugins {
    `kotlin-jvm`
}

dependencies {
    implementation(project(Dependencies.Module.DATA))

    implementation(Dependencies.INJECT)

    // TODO: GRPC
}
