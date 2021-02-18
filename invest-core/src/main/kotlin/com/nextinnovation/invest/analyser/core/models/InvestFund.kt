package com.nextinnovation.invest.analyser.core.models

import javax.persistence.*

@Table(name = "investFunds")
@Entity
data class InvestFund(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var investFundId: Long? = null,

  @Column
  @Enumerated(EnumType.STRING)
  var investCompany: InvestCompany,

  @Column
  var name: String,

  @Column
  var ticker: String,
)
