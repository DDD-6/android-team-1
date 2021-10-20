dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://devrepo.kakao.com/nexus/content/groups/public/") }
    }
}

rootProject.name = "AppCha"
include(":app")
include(":ui")
include(":ui-compose")
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
