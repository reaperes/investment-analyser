CREATE TABLE investCompanies
(
    investCompanyId BIGINT AUTO_INCREMENT PRIMARY KEY,
    name            VARCHAR(100) NOT NULL
) CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE companies
(
    companyId BIGINT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(100) NOT NULL,
    ticker    VARCHAR(50)  NOT NULL,
    cusip     VARCHAR(50)  NOT NULL
) CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE publishedHoldings
(
    publishedHoldingId BIGINT AUTO_INCREMENT PRIMARY KEY,
    investCompanyId    BIGINT NOT NULL,
    companyId          BIGINT NOT NULL,
    shares             BIGINT NOT NULL,
    published          DATE   NOT NULL
) CHARACTER SET utf8
  COLLATE utf8_general_ci;
