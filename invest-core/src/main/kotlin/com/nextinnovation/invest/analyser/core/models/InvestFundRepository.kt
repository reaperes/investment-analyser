package com.nextinnovation.invest.analyser.core.models

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvestFundRepository : JpaRepository<InvestFund, Long> {
  fun findByCusip(cusip: String): InvestFund
}
