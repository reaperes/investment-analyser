import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

dependencies {
  val kotestVersion = "4.4.0"
  val mapstructVersion = "1.4.2.Final"

  implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.4.20"))

  implementation("org.springframework.boot:spring-boot-starter")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")
  implementation("com.jayway.jsonpath:json-path:2.5.0")
  implementation("org.mapstruct:mapstruct:$mapstructVersion")
  implementation("io.github.microutils:kotlin-logging-jvm:2.0.4")

  kapt("org.mapstruct:mapstruct-processor:$mapstructVersion")

  runtimeOnly("org.mariadb.jdbc:mariadb-java-client:2.7.2")

  testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
  testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
}

tasks.withType<Test> {
  useJUnitPlatform()
}

sourceSets {
  create("intTest") {
    withConvention(KotlinSourceSet::class) {
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
