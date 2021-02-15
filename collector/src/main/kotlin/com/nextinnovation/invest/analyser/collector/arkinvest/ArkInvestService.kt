package com.nextinnovation.invest.analyser.collector.arkinvest

import com.nextinnovation.invest.analyser.core.models.*
import mu.KotlinLogging
import org.springframework.stereotype.Service

private val log = KotlinLogging.logger {}

@Service
class ArkInvestService(
  val arkInvestClient: ArkInvestClient,
  val companyRepository: CompanyRepository,
  val publishedHoldingRepository: PublishedHoldingRepository,
) {
  fun saveTodayPortfolio() {
    log.info("--- Start to save ${InvestCompany.ARK.readableName} 's published holdings on today")

    log.info("Fetching today ArkInvest portfolio...")
    val records = arkInvestClient.getTodayPortfolioRecords()
    log.info("Successfully completed. Total fetched records: ${records.size}")

    log.info("Start to update company list")
    val updatedCompanies = updateCompanyListIfNotExists(records)
    log.info("Successfully completed. Total updated companies: ${updatedCompanies.size}")

    log.info("Start to update published holdings")
    val updatedPublishedHoldings = updatePublishedHoldings(records)
    log.info("Successfully completed. Total updated published holdings: ${updatedPublishedHoldings.size}")

    log.info("--- Successfully completed: Save ${InvestCompany.ARK.readableName} 's published holdings on today")
  }

  private fun updateCompanyListIfNotExists(records: List<ArkInvestPortfolioRecord>): List<Company> {
    val notExistsCompanies = records.filter { record ->
      !companyRepository.findByCusip(record.cusip).isPresent
    }

    if (notExistsCompanies.isEmpty()) {
      log.info("Skip to update company list - all companies exist already")
    }

    return notExistsCompanies.map { notExistCompany ->
      val company = Company(
        name = notExistCompany.company,
        ticker = notExistCompany.ticker,
        cusip = notExistCompany.cusip,
      )
      companyRepository.save(company)
    }
  }

  // TODO: performance tuning
  private fun updatePublishedHoldings(records: List<ArkInvestPortfolioRecord>): List<PublishedHolding> {
    return records
      // filter not updated yet
      .filter { record ->
        val company = companyRepository.findByCusip(record.cusip).orElseThrow {
          throw IllegalStateException("Company does not exist. Company cusip: ${record.cusip}")
        }
        !publishedHoldingRepository.findByInvestCompanyAndCompanyAndPublished(
          InvestCompany.ARK, company, record.date
        ).isPresent
      }
      // Update new published holding
      .map { record ->
        val company = companyRepository.findByCusip(record.cusip).orElseThrow {
          throw IllegalStateException("Company does not exist. Company cusip: ${record.cusip}")
        }
        val publishedHolding = PublishedHolding(
          investCompany = InvestCompany.ARK,
          company = company,
          shares = record.shares,
          published = record.date
        )
        publishedHoldingRepository.save(publishedHolding)
      }
  }
}
