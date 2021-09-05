buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.Project.GRADLE)
        classpath(Dependencies.Project.KOTLIN)
        classpath(Dependencies.Project.NAVIGATION)
        classpath(Dependencies.Project.HILT)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}