ALTER TABLE investFunds ADD cusip VARCHAR(50) NOT NULL AFTER ticker;

ALTER TABLE investFunds ADD csvUrl VARCHAR(500) NOT NULL AFTER cusip;

ALTER TABLE investFunds DROP INDEX ux_investFunds_ticker;

/* ============ Migrate data ============ */

UPDATE investFunds SET cusip = "00214Q104", csvUrl = "https://ark-funds.com/wp-content/fundsiteliterature/csv/ARK_NEXT_GENERATION_INTERNET_ETF_ARKW_HOLDINGS.csv" WHERE ticker = "ARKK";
UPDATE investFunds SET cusip = "00214Q203", csvUrl = "https://ark-funds.com/wp-content/fundsiteliterature/csv/ARK_AUTONOMOUS_TECHNOLOGY_&_ROBOTICS_ETF_ARKQ_HOLDINGS.csv" WHERE ticker = "ARKQ";
UPDATE investFunds SET cusip = "00214Q401", csvUrl = "https://ark-funds.com/wp-content/fundsiteliterature/csv/ARK_NEXT_GENERATION_INTERNET_ETF_ARKW_HOLDINGS.csv" WHERE ticker = "ARKW";
UPDATE investFunds SET cusip = "00214Q302", csvUrl = "https://ark-funds.com/wp-content/fundsiteliterature/csv/ARK_GENOMIC_REVOLUTION_MULTISECTOR_ETF_ARKG_HOLDINGS.csv" WHERE ticker = "ARKG";
UPDATE investFunds SET cusip = "00214Q708", csvUrl = "https://ark-funds.com/wp-content/fundsiteliterature/csv/ARK_FINTECH_INNOVATION_ETF_ARKF_HOLDINGS.csv" WHERE ticker = "ARKF";
UPDATE investFunds SET cusip = "00214Q500", csvUrl = "https://ark-funds.com/wp-content/fundsiteliterature/csv/THE_3D_PRINTING_ETF_PRNT_HOLDINGS.csv" WHERE ticker = "PRNT";
UPDATE investFunds SET cusip = "00214Q609", csvUrl = "https://ark-funds.com/wp-content/fundsiteliterature/csv/ARK_ISRAEL_INNOVATIVE_TECHNOLOGY_ETF_IZRL_HOLDINGS.csv" WHERE ticker = "IZRL";

/* unique constraint can not added before migration */

ALTER TABLE investFunds ADD UNIQUE INDEX ux_investFunds_cusip (cusip);
