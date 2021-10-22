import com.google.protobuf.gradle.generateProtoTasks
import com.google.protobuf.gradle.id
import com.google.protobuf.gradle.ofSourceSet
import com.google.protobuf.gradle.plugins
import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    `kotlin-jvm`
    `kotlin-kapt`
    protobuf
}

dependencies {
    implementation(project(Dependencies.Module.DATA))
    implementation(project(Dependencies.Module.CORE_ARCH))

    implementation(Dependencies.COROUTINES_CORE)

    implementation(Dependencies.HILT_CORE)
    kapt(Dependencies.HILT_COMPILER)

    runtimeOnly(Dependencies.GRPC_OKHTTP)
    implementation(Dependencies.GRPC_STUB)
    implementation(Dependencies.GRPC_PROTOBUF_LITE)
    implementation(Dependencies.GRPC_KOTLIN_STUB)
    implementation(Dependencies.PROTOBUF_JAVALITE)

    protobuf(files("$rootDir/appcha-protobuf/protobuf"))
}

protobuf {
    protoc { artifact = "com.google.protobuf:protoc:${Versions.PROTOBUF}" }
    plugins {
        id("grpc") { artifact = "io.grpc:protoc-gen-grpc-java:${Versions.GRPC}" }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:${Versions.GRPC_KOTLIN}:jdk7@jar"
        }
    }
    generateProtoTasks {
        all().forEach { task ->
            task.builtins {
                named("java") { option("lite") }
            }
            task.plugins {
                id("grpc") { option("lite") }
                id("grpckt") { option("lite") }
            }
        }
    }
}
