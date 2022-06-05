rootProject.name = "versioncatalog-demo"

dependencyResolutionManagement {
    versionCatalogs {
        create("tools") {
            version("kotlin", "1.6.21")

            plugin("spring-boot", "org.springframework.boot").version("2.7.0")
            plugin("spring-dependencymanager", "io.spring.dependency-management").version("1.0.11.RELEASE")
            plugin("kotlin-lang", "org.jetbrains.kotlin.jvm").versionRef("kotlin")
            plugin("kotlin-spring", "org.jetbrains.kotlin.plugin.spring").versionRef("kotlin")
        }

        create("libs") {
            version("testcontainers", "1.17.2")

            library("kotlin_logging", "io.github.microutils:kotlin-logging-jvm:2.1.20")
            library("guava", "com.google.guava:guava:31.1-jre")
            library("testcontainers-core", "org.testcontainers", "testcontainers").versionRef("testcontainers")
            library("testcontainers-mongodb", "org.testcontainers", "mongodb").versionRef("testcontainers")

            bundle("testcontainers", listOf("testcontainers-core", "testcontainers-mongodb"))
        }
    }
}