CREATE TABLE investFunds
(
    investFundId  BIGINT AUTO_INCREMENT PRIMARY KEY,
    investCompany VARCHAR(50)  NOT NULL,
    name          VARCHAR(100) NOT NULL,
    ticker        VARCHAR(50)  NOT NULL,
    CONSTRAINT ux_investFunds_ticker UNIQUE (ticker),
    CONSTRAINT ux_investFunds_companyId_name UNIQUE (investCompany, name)
) CHARACTER SET utf8
  COLLATE utf8_general_ci;

ALTER TABLE publishedHoldings DROP INDEX ux_publishedHoldings_investCompany_companyId_published;

ALTER TABLE publishedHoldings DROP COLUMN investCompany;

ALTER TABLE publishedHoldings ADD investFundId BIGINT NOT NULL AFTER publishedHoldingId;

ALTER TABLE publishedHoldings ADD UNIQUE INDEX ux_publishedHoldings_investFundId_companyId_published (investFundId, companyId, published);

/* ============ Migrate data ============ */

INSERT INTO investFunds (investCompany, name, ticker) VALUES ("ARK", "ARK Innovation ETF", "ARKK");

UPDATE publishedHoldings SET investFundId = (SELECT investFundId FROM investFunds WHERE ticker = "ARKK");

INSERT INTO investFunds (investCompany, name, ticker) VALUES
    ("ARK", "Autonomous Technology & Robotics ETF", "ARKQ"),
    ("ARK", "Next Generation Internet ETF", "ARKW"),
    ("ARK", "Genomic Revolution ETF", "ARKG"),
    ("ARK", "Fintech Innovation ETF", "ARKF"),
    ("ARK", "Total 3D-Printing Index", "PRNT"),
    ("ARK", "ARK Israeli Innovation Index", "IZRL");
