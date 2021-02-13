package com.nextinnovation.invest.analyser.collector.models

import java.time.LocalDate
import javax.persistence.*


@Table(name = "publishedHoldings")
@Entity
data class PublishedHolding(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var publishedHoldingId: Long? = null,

  @Column
  @Enumerated(EnumType.STRING)
  var investCompany: InvestCompany,

  @ManyToOne
  @JoinColumn(name = "companyId", nullable = false)
  var company: Company,

  @Column
  var shares: Double,

  @Column
  var published: LocalDate
)
