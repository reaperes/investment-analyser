package com.nextinnovation.invest.analyser.collector

import com.nextinnovation.invest.analyser.core.CoreConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackageClasses = [CoreConfiguration::class])
class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
