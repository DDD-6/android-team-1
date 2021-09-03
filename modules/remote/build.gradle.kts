plugins {
    id(Configs.KOTLIN_JVM)
}

dependencies {
    implementation(project(Dependencies.Module.DATA))
    // TODO: GRPC
}
