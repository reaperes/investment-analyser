package com.nextinnovation.invest.analyser.collectorbackup

import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


private val log = KotlinLogging.logger {}

@SpringBootApplication
class CollectorBackupApplication : CommandLineRunner {
  override fun run(vararg args: String?) {
    log.info("Hello, world!")
  }
}

fun main(args: Array<String>) {
  runApplication<CollectorBackupApplication>(*args)
}
