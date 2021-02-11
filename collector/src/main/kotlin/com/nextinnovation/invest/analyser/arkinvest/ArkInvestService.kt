package com.nextinnovation.invest.analyser.arkinvest

import mu.KotlinLogging
import org.springframework.stereotype.Service

private val log = KotlinLogging.logger {}

@Service
class ArkInvestService(
  val arkInvestClient: ArkInvestClient,
) {
  fun saveTodayPortfolio() {
    log.info("Fetching today ArkInvest portfolio")
    val records = arkInvestClient.getTodayPortfolioRecords()

  }
}
