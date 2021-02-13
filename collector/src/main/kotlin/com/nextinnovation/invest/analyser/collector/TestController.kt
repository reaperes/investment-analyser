package com.nextinnovation.invest.analyser.collector

import com.nextinnovation.invest.analyser.collector.arkinvest.ArkInvestService
import org.springframework.web.bind.annotation.RestController

@RestController
class TestController(
  val arkInvestService: ArkInvestService
) {
//  @ResponseStatus(HttpStatus.OK)
//  @GetMapping("/")
//  fun test() {
//    return arkInvestService.saveTodayPortfolio()
//  }
}
