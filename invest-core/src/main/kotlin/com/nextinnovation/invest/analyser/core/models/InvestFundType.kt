package com.nextinnovation.invest.analyser.core.models

enum class InvestFundType(val ticker: String, val readableName: String) {
  ARKK("ARKK", "ARK Innovation ETF"),
  ARKQ("ARKQ", "Autonomous Technology & Robotics ETF"),
  ARKW("ARKW", "Next Generation Internet ETF"),
  ARKG("ARKG", "Genomic Revolution ETF"),
  ARKF("ARKF", "Fintech Innovation ETF"),
  PRNT("PRNT", "Total 3D-Printing Index"),
  IZRL("IZRL", "ARK Israeli Innovation Index"),
}
