pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    plugins {
        
        val kotlinVersion: String by settings        
        val micronautPluginVersion: String by settings
        val shadowPluginVersion: String by settings
        val wsdl2javaVersion: String by settings

        kotlin("jvm") version kotlinVersion
        kotlin("plugin.allopen") version kotlinVersion
        kotlin("kapt") version kotlinVersion
        id("io.micronaut.application") version micronautPluginVersion
        id("com.github.johnrengelman.shadow") version shadowPluginVersion
        id("com.github.bjornvester.wsdl2java") version wsdl2javaVersion
    }
}

val projectName: String by extra
rootProject.name=projectName

