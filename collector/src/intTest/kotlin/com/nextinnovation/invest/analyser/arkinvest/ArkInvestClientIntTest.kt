package com.nextinnovation.invest.analyser.arkinvest

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.StringReader


internal class ArkInvestClientIntTest : StringSpec({

  lateinit var arkInvestClient: ArkInvestClient

  beforeTest {
    arkInvestClient = ArkInvestClient()
  }

  "arkInvestClient should download csv formatted portfolio" {
    val str = arkInvestClient.getPortfolio()
    val records = CSVParser(StringReader(str), CSVFormat.DEFAULT)
    records.forEach {
      print(it)
    }
  }

  "test" {
    arkInvestClient.parse()
    1 + 1 shouldBe 2
  }
})
