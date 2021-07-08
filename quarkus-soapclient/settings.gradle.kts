pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    plugins {
        
        val kotlinVersion: String by settings        
        val quarkusPluginVersion: String by settings
        val quarkusPluginId: String by settings
        val wsdl2javaVersion: String by settings

        kotlin("jvm") version kotlinVersion
        kotlin("plugin.allopen") version kotlinVersion

        id(quarkusPluginId) version quarkusPluginVersion
        id("com.github.bjornvester.wsdl2java") version wsdl2javaVersion
    }
}

val projectName: String by extra
rootProject.name=projectName
