package com.nextinnovation.invest.analyser.collectorbackup

import com.nextinnovation.invest.analyser.core.CoreConfiguration
import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


private val log = KotlinLogging.logger {}

@SpringBootApplication(scanBasePackageClasses = [CoreConfiguration::class])
class CollectorBackupApplication : CommandLineRunner {
  override fun run(vararg args: String?) {
    log.info("Hello, world!")
  }
}

fun main(args: Array<String>) {
  runApplication<CollectorBackupApplication>(*args)
}
