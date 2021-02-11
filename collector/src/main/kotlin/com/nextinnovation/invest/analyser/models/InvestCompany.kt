package com.nextinnovation.invest.analyser.models

import javax.persistence.*

@Table(name = "investCompanies")
@Entity
data class InvestCompany(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var investCompanyId: Long?,

  @Column
  var name: String,

  @OneToMany
  var holdings: MutableList<PublishedHolding> = mutableListOf()
)
