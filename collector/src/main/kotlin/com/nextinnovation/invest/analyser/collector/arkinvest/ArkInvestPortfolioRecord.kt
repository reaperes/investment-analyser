package com.nextinnovation.invest.analyser.collector.arkinvest

import java.time.LocalDate

// Record sample
// date,fund,company,ticker,cusip,shares,"market value(${'$'})",weight(%)
// 2/10/2021, ARKW, "TESLA INC", TSLA, 88160R101, 914864.00, 736300844.48, 8.40
class ArkInvestPortfolioRecord {
  lateinit var date: LocalDate
  lateinit var fund: String
  lateinit var company: String
  lateinit var ticker: String
  lateinit var cusip: String
  var shares: Double = 0.0
  var marketValue: Double = 0.0
  var weight: Double = 0.0
}
