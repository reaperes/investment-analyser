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

val kotlinProjects = listOf(
  project("invest-core"),
  project("collector"),
  project("collector-backup")
)

configure(kotlinProjects) {
  apply(plugin = "kotlin")
  apply(plugin = "kotlin-spring")
  apply(plugin = "kotlin-jpa")
  apply(plugin = "kotlin-kapt")
  apply(plugin = "io.spring.dependency-management")
  apply(plugin = "org.springframework.boot")

  dependencies {
    val kotestVersion = "4.4.0"

    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.4.20"))

    testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
  }

  tasks {
    compileKotlin {
      kotlinOptions.jvmTarget = "1.8"
      kotlinOptions.freeCompilerArgs = listOf("-Xjsr305=strict")
    }
  }

  tasks.withType<Test> {
    useJUnitPlatform()
  }

  sourceSets {
    create("intTest") {
      withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
        kotlin.srcDir("src/intTest/kotlin")
        resources.srcDir("src/intTest/resources")
        compileClasspath += sourceSets["main"].output + configurations["testRuntimeClasspath"]
        runtimeClasspath += output + compileClasspath + sourceSets["test"].runtimeClasspath
      }
    }
  }

  task<Test>("intTest") {
    group = "verification"
    description = "Runs the integration tests"

    testClassesDirs = sourceSets["intTest"].output.classesDirs
    classpath = sourceSets["intTest"].runtimeClasspath

    mustRunAfter(tasks["test"])
  }
}

subprojects {
  task<Copy>("installGitHooks") {
    group = "build setup"
    description = "Install git hooks"

    from(file("$rootDir/hooks/pre-commit"))
    into(file("$rootDir/.git/hooks"))
  }
}
