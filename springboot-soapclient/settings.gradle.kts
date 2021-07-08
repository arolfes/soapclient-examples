pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    plugins {
        
        val kotlinVersion: String by settings        
        val springBootVersion: String by settings
        val springDependencyManagementVersion: String by settings
        

        kotlin("jvm") version kotlinVersion
        kotlin("plugin.allopen") version kotlinVersion
        kotlin("plugin.spring") version kotlinVersion

        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version springDependencyManagementVersion
    }
}

val projectName: String by extra
rootProject.name=projectName
