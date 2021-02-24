dependencies {
  implementation(project(":invest-core"))

  implementation("org.springframework.boot:spring-boot-starter")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.1")

  runtimeOnly("org.mariadb.jdbc:mariadb-java-client:2.7.2")
}
