import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

dependencies {
  val kotestVersion = "4.4.0"
  val mapstructVersion = "1.4.2.Final"

  implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.4.20"))

  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")
  implementation("com.jayway.jsonpath:json-path:2.5.0")
  implementation("org.mapstruct:mapstruct:$mapstructVersion")
  implementation("org.mapstruct:mapstruct-jdk8:$mapstructVersion")

  annotationProcessor("org.mapstruct:mapstruct-processor:$mapstructVersion")

  runtimeOnly("org.flywaydb:flyway-core:7.5.2")
  runtimeOnly("org.mariadb.jdbc:mariadb-java-client:2.7.2")

  testImplementation("io.kotest:kotest-runner-junit5:$kotestVersion")
  testImplementation("io.kotest:kotest-assertions-core:$kotestVersion")
}

tasks.withType<Test> {
  useJUnitPlatform()
}
