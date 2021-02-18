package com.nextinnovation.invest.analyser.collector.arkinvest

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.io.StringReader

@Component
class ArkInvestClient(
  private val restTemplate: RestTemplate = defaultArkInvestRestTemplate,
  private val arkInvestPortfolioRecordMapper: ArkInvestPortfolioRecordMapper,
) {
  fun getPortfolioCSV(url: String): String {
    return restTemplate.getForEntity(url, String::class.java).body!!
  }

  fun getTodayPortfolioRecords(url: String): List<ArkInvestPortfolioRecord> {
    val csv = getPortfolioCSV(url)
    val records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(StringReader(csv)).records

    return records
      .filter { isNotEmptyRecord(it) }
      .map(arkInvestPortfolioRecordMapper::fromRawRecord)
  }

  private fun isNotEmptyRecord(record: CSVRecord): Boolean {
    val lastColumnIdx = record.size() - 1
    return !record.get(lastColumnIdx).isEmpty()
  }
}

val defaultArkInvestRestTemplate: RestTemplate = RestTemplateBuilder()
  .defaultHeader("user-agent", "Mozilla/5.0 Firefox/26.0")  // Fake user agent is browser
  .build()
