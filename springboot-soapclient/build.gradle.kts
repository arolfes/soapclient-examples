import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot")
	id("io.spring.dependency-management")
	kotlin("jvm")
	kotlin("plugin.spring")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val groupId: String by project
val projectVersion: String by project

group = groupId
version = projectVersion

val jvmTargetVersion: String by project

val jaxbVersion: String by project

java.sourceCompatibility = JavaVersion.VERSION_11

/**
 * JAXB Konfiguration
 */
val jaxb = configurations.create("jaxb") // configures JAXB
val classesDir = "$buildDir/classes/jaxb"
val wsdlDir = "$projectDir/src/main/resources/wsdl"

/**
 * Uses ant task (due to Gradle not having JAXB plugin) for generating Java classes from WSDL/XSD files.
 */
task("genJaxb") {

    val sourcesDir = "$buildDir/generated-sources/jaxb"

    outputs.dir(classesDir)

    doLast {
        project.ant.withGroovyBuilder {
            "taskdef"(
                "name" to "xjc",
                "classname" to "com.sun.tools.xjc.XJCTask",
                "classpath" to jaxb.asPath
            )
            "mkdir"("dir" to sourcesDir)
            "mkdir"("dir" to classesDir)

            "xjc"("destdir" to sourcesDir) {
                "schema"(
                    "dir" to wsdlDir,
                    "includes" to "**/*.wsdl"
                )
                "arg"("value" to "-wsdl")
                "produces"("dir" to sourcesDir, "includes" to "**/*.java")
            }

            "javac"(
                "destdir" to classesDir,
                "source" to jvmTargetVersion, "target" to jvmTargetVersion, "debug" to "true",
                "debugLevel" to "lines,vars,source",
                "classpath" to jaxb.asPath
            ) {
                "src"("path" to sourcesDir)
                "include"("name" to "**/*.java")
                "include"("name" to "*.java")
            }

            "copy"("todir" to classesDir) {
                "fileset"("dir" to sourcesDir, "erroronmissingdir" to "false") {
                    "exclude"("name" to "**/*.java")
                }
            }
        }
    }
}


dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	
	jaxb("org.glassfish.jaxb:jaxb-xjc:$jaxbVersion")
    jaxb("org.glassfish.jaxb:jaxb-runtime:$jaxbVersion")

    runtimeOnly("io.micrometer:micrometer-registry-prometheus")

    implementation("org.springframework.boot:spring-boot-starter-web-services")
    implementation(files(classesDir).builtBy("genJaxb"))
    implementation("org.glassfish.jaxb:jaxb-runtime:$jaxbVersion")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = jvmTargetVersion
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
