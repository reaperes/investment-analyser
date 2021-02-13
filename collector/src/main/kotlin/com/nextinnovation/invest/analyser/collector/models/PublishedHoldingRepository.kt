package com.nextinnovation.invest.analyser.collector.models

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDate
import java.util.*

@Repository
interface PublishedHoldingRepository : JpaRepository<PublishedHolding, Long> {
  fun findByInvestCompanyAndCompanyAndPublished(
    investCompany: InvestCompany,
    company: Company,
    published: LocalDate,
  ): Optional<PublishedHolding>
}
