package com.nextinnovation.invest.analyser.models

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PublishedHoldingRepository : JpaRepository<Company, Long>
