plugins {
    id(Configs.KOTLIN_JVM)
}

dependencies {
    implementation(project(Dependencies.Module.DOMAIN))

    implementation(Dependencies.INJECT)
    implementation(Dependencies.COROUTINES)
}
