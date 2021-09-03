buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Configs.Project.GRADLE)
        classpath(Configs.Project.KOTLIN)
        classpath(Configs.Project.NAVIGATION)
        classpath(Configs.Project.HILT)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}