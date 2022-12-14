
CREATE TABLE IF NOT EXISTS RF_COMMONS_TAXES(
ID INT AUTO_INCREMENT PRIMARY KEY,
CODE VARCHAR(4),
NAME VARCHAR(30),
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NOT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME,
CONSTRAINT UQ_CM_TX_CD UNIQUE (BUSINESS_CUSTOMER_ID, ENTERPRISE_ID,CODE)
);

CREATE TABLE IF NOT EXISTS RF_COMMONS_TAXES_VERSIONS(
ID INT AUTO_INCREMENT PRIMARY KEY,
START_DATE DATE NOT NULL,
RATE DECIMAL(18,6) NOT NULL,
COMMON_TAX_ID INT NOT NULL,
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NOT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME,
FOREIGN KEY (COMMON_TAX_ID) REFERENCES RF_COMMONS_TAXES(ID),
CONSTRAINT UQ_CM_TX_VR_DT UNIQUE (BUSINESS_CUSTOMER_ID, ENTERPRISE_ID,START_DATE)
);