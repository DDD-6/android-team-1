dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AppCha"
include(":presentation")
include(":domain")
include(":data")
include(":remote")
include(":local")

include(":core-arch")
include(":core-ui")

for (project in rootProject.children) {
    project.projectDir = file("modules/${project.name}")
}
