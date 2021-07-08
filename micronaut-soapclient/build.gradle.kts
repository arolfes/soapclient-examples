plugins {

    kotlin("jvm")
    kotlin("kapt") 
    kotlin("plugin.allopen")

    id("com.github.johnrengelman.shadow")
    id("io.micronaut.application")
    id("com.github.bjornvester.wsdl2java")
}

val groupId: String by project
val projectVersion: String by project

group = groupId
version = projectVersion

val jvmTargetVersion: String by project

val cxfVersion: String by project
val slf4jVersion: String by project

repositories {
    mavenCentral()
}

micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("info.novatec.examples.soapclient.micronaut.*")
    }
}

dependencies {
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-runtime")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("javax.annotation:javax.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")

    implementation("io.micronaut:micronaut-management")
    implementation("io.micronaut.micrometer:micronaut-micrometer-registry-prometheus")
    implementation("io.micronaut.micrometer:micronaut-micrometer-core")

    /** cxf libs */
    implementation("org.apache.cxf:cxf-rt-frontend-jaxws:$cxfVersion")
    implementation("org.apache.cxf:cxf-rt-transports-http:$cxfVersion")
    implementation("org.slf4j:log4j-over-slf4j:$slf4jVersion")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

}


application {
    mainClass.set("info.novatec.examples.soapclient.micronaut.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion(jvmTargetVersion)
    targetCompatibility = JavaVersion.toVersion(jvmTargetVersion)
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = jvmTargetVersion
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = jvmTargetVersion
        }
    }


}
