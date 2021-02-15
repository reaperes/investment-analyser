package com.nextinnovation.invest.analyser.core.models

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CompanyRepository : JpaRepository<Company, Long> {
  fun findByCusip(cusip: String): Optional<Company>
}
