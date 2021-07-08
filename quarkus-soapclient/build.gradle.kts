plugins {
    kotlin("jvm") 
    kotlin("plugin.allopen")
    id("io.quarkus")
    id("com.github.bjornvester.wsdl2java")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val groupId: String by project
val projectVersion: String by project

group = groupId
version = projectVersion

java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = java.sourceCompatibility
val jvmTargetVersion = java.sourceCompatibility.toString()

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project
val quarkusCxfVersion: String by project


dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))

    implementation("io.quarkus:quarkus-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-resteasy")
    implementation("io.quarkus:quarkus-resteasy-jackson")

    implementation("io.quarkiverse.cxf:quarkus-cxf:$quarkusCxfVersion")

    implementation("io.quarkus:quarkus-micrometer-registry-prometheus")
    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
}


allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = jvmTargetVersion
    kotlinOptions.javaParameters = true
}
