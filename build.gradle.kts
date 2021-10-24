buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.Project.GRADLE)
        classpath(Dependencies.Project.KOTLIN)
        classpath(Dependencies.Project.HILT)
        classpath(Dependencies.Project.PROTOBUF_GRADLE_PLUGIN)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
