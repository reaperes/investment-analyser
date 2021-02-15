dependencies {
  val mapstructVersion = "1.4.2.Final"

  implementation(project(":invest-core"))

  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jpa")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")
  implementation("com.jayway.jsonpath:json-path:2.5.0")
  implementation("org.mapstruct:mapstruct:$mapstructVersion")
  implementation("org.apache.commons:commons-csv:1.8")
  implementation("io.github.microutils:kotlin-logging-jvm:2.0.4")

  kapt("org.mapstruct:mapstruct-processor:$mapstructVersion")

  runtimeOnly("org.flywaydb:flyway-core:7.5.3")
  runtimeOnly("org.mariadb.jdbc:mariadb-java-client:2.7.2")
}
