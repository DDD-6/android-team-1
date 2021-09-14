dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AppCha"
include(":app")
include(":ui")
include(":domain")
include(":data")
include(":remote")
include(":local")

include(":core-arch")
include(":core-ui")

include(":navigation")

for (project in rootProject.children) {
    project.projectDir = file("modules/${project.name}")
}
