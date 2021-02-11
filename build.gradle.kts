plugins {
  val kotlinVersion = "1.4.21"

  kotlin("jvm") version kotlinVersion
  kotlin("plugin.spring") version kotlinVersion
  kotlin("plugin.jpa") version kotlinVersion
  kotlin("kapt") version kotlinVersion

  id("org.springframework.boot") version "2.4.2"
  id("io.spring.dependency-management") version "1.0.11.RELEASE"
}

allprojects {
  repositories {
    mavenCentral()
  }
}

subprojects {
  apply(plugin = "kotlin")
  apply(plugin = "kotlin-spring")
  apply(plugin = "kotlin-jpa")
  apply(plugin = "kotlin-kapt")
  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "org.springframework.boot")

  tasks {
    compileKotlin {
      kotlinOptions.jvmTarget = "1.8"
      kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
    }
  }
}
