package com.nextinnovation.invest.analyser.models

import java.time.LocalDate
import javax.persistence.*


@Table(name = "publishedHoldings")
@Entity
data class PublishedHolding(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var publishedHoldingId: Long?,

  @ManyToOne
  var investCompany: InvestCompany,

  @ManyToOne
  var company: Company,

  @Column
  var shares: Long,

  @Column
  var published: LocalDate
)
