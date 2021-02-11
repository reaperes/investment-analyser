CREATE TABLE companies
(
    companyId BIGINT AUTO_INCREMENT PRIMARY KEY,
    name      VARCHAR(100) NOT NULL,
    ticker    VARCHAR(50)  NOT NULL,
    cusip     VARCHAR(50)  NOT NULL,
    CONSTRAINT ux_companies_cusip UNIQUE (cusip)
) CHARACTER SET utf8
  COLLATE utf8_general_ci;

CREATE TABLE publishedHoldings
(
    publishedHoldingId BIGINT AUTO_INCREMENT PRIMARY KEY,
    investCompany      VARCHAR(50) NOT NULL,
    companyId          BIGINT      NOT NULL,
    shares             DOUBLE      NOT NULL,
    published          DATE        NOT NULL,
    CONSTRAINT ux_publishedHoldings_investCompany_companyId_published UNIQUE (investCompany, companyId, published)
) CHARACTER SET utf8
  COLLATE utf8_general_ci;
