package com.nextinnovation.invest.analyser.collector

import com.nextinnovation.invest.analyser.core.CoreConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = [CoreConfiguration::class])
@EntityScan(basePackageClasses = [CoreConfiguration::class])
class Application

fun main(args: Array<String>) {
  runApplication<Application>(*args)
}
