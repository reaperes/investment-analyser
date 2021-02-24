package com.nextinnovation.invest.analyser.collectorbackup

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.runApplication
import java.io.File
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit


private val log = KotlinLogging.logger {}

@SpringBootApplication
class CollectorBackupApplication : CommandLineRunner {

  @Autowired
  private lateinit var dataSourceProperties: DataSourceProperties

  override fun run(vararg args: String?) {
    val hostAndPortAndDatabase = dataSourceProperties.url
      .replace(Regex("""(\w+:)+//"""), "")  // remove scheme
      .split("/")
    val hostAndPort = hostAndPortAndDatabase.first()
      .split(":")
    val database = hostAndPortAndDatabase.last()
    val host = hostAndPort.first()
    val port = hostAndPort.last()
    val username = dataSourceProperties.username
    val password = dataSourceProperties.password

    val dumpCommand = "mysqldump --databases $database --protocol tcp -h $host --port $port -u $username -p$password"

    log.info("Start to dump: $dumpCommand")

    val pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val now = LocalDateTime.now()
    val dumpFileName = "${pattern.format(now)}.sql"
    val dumpFile = File(dumpFileName)

    val process = ProcessBuilder(*dumpCommand.split(" ").toTypedArray())
      .redirectInput(dumpFile)
      .redirectError(ProcessBuilder.Redirect.INHERIT)
      .start()

    if (!process.waitFor(10, TimeUnit.SECONDS)) {
      process.destroy()
      throw RuntimeException("mysqldump timed out: $this")
    }

    if (process.exitValue() != 0) {
      throw RuntimeException("mysqldump failed with code ${process.exitValue()}: $this")
    }

    log.info("Completed to dump. File: $dumpFileName")
  }
}

fun main(args: Array<String>) {
  runApplication<CollectorBackupApplication>(*args)
}
