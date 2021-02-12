package com.nextinnovation.invest.analyser

import com.nextinnovation.invest.analyser.arkinvest.ArkInvestService
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
