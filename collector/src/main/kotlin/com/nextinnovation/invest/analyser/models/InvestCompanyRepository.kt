package com.nextinnovation.invest.analyser.models

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface InvestCompanyRepository : JpaRepository<Company, Long>
