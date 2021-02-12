package com.nextinnovation.invest.analyser.api

import com.nextinnovation.invest.analyser.arkinvest.ArkInvestService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class CollectController(
  val arkInvestService: ArkInvestService
) {
  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/collect")
  fun test() {
    return arkInvestService.saveTodayPortfolio()
  }
}
