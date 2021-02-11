package com.nextinnovation.invest.analyser.arkinvest

import org.apache.commons.csv.CSVRecord
import org.mapstruct.Mapper
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Mapper(componentModel = "spring")
abstract class ArkInvestPortfolioRecordMapper {
  fun fromRawRecord(rawRecord: CSVRecord): ArkInvestPortfolioRecord {
    return ArkInvestPortfolioRecord().apply {
      val strDate = rawRecord.get("date")
      date = LocalDate.parse(strDate, DateTimeFormatter.ofPattern("M/d/yyyy"))
      fund = rawRecord.get("fund")
      company = rawRecord.get("company")
      ticker = rawRecord.get("ticker")
      cusip = rawRecord.get("cusip")
      shares = rawRecord.get("shares").toDouble()
      marketValue = rawRecord.get("""market value($)""").toDouble()
      weight = rawRecord.get("weight(%)").toDouble()
    }
  }
}
