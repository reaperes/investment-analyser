package com.nextinnovation.invest.analyser.core.models

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface PublishedHoldingRepository : JpaRepository<PublishedHolding, Long> {
  fun findByInvestFundAndCompanyAndPublished(
    investFund: InvestFund,
    company: Company,
    published: LocalDate,
  ): Optional<PublishedHolding>
}
