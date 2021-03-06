package com.nextinnovation.invest.analyser.core.models

import java.time.LocalDate
import javax.persistence.*


@Table(name = "publishedHoldings")
@Entity
data class PublishedHolding(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var publishedHoldingId: Long? = null,

  @ManyToOne
  @JoinColumn(name = "investFundId", nullable = false)
  var investFund: InvestFund,

  @ManyToOne
  @JoinColumn(name = "companyId", nullable = false)
  var company: Company,

  @Column
  var shares: Double,

  @Column
  var published: LocalDate
)
