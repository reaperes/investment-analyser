dependencies {
  val mapstructVersion = "1.4.2.Final"

  implementation(project(":invest-core"))

  implementation("org.springframework.boot:spring-boot-starter")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")
  implementation("com.jayway.jsonpath:json-path:2.5.0")
  implementation("org.mapstruct:mapstruct:$mapstructVersion")
  implementation("io.github.microutils:kotlin-logging-jvm:2.0.4")

  kapt("org.mapstruct:mapstruct-processor:$mapstructVersion")

  runtimeOnly("org.mariadb.jdbc:mariadb-java-client:2.7.2")
}
