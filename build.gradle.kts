import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	alias(tools.plugins.spring.boot)
	alias(tools.plugins.spring.dependencymanager)
	alias(tools.plugins.kotlin.lang)
	alias(tools.plugins.kotlin.spring)
}

group = "tech.zone84.examples.versioncatalogs"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation(libs.kotlin.logging)
	implementation(libs.guava)

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation(libs.bundles.testcontainers)
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
