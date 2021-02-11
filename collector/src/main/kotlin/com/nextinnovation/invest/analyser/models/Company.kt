package com.nextinnovation.invest.analyser.models

import javax.persistence.*

@Table(name = "companies")
@Entity
data class Company(
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  var companyId: Long?,

  @Column
  var name: String,

  @Column
  var ticker: String,

  @Column
  var cusip: String,
)
