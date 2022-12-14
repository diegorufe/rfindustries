
CREATE TABLE IF NOT EXISTS RF_ACCOUNTING_ACCOUNTING(
ID INT AUTO_INCREMENT PRIMARY KEY,
CODE VARCHAR(4) NOT NULL,
NAME VARCHAR(30) NOT NULL,
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NOT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME,
CONSTRAINT UQ_ACC_ACC_COD UNIQUE (BUSINESS_CUSTOMER_ID, ENTERPRISE_ID, CODE)
);

CREATE TABLE IF NOT EXISTS RF_ACCOUNTING_ACCOUNTING_YEARS(
ID INT AUTO_INCREMENT PRIMARY KEY,
ACCOUNTING_ID INT NOT NULL,
CODE VARCHAR(4) NOT NULL,
NAME VARCHAR(30) NOT NULL,
START_DATE DATE NOT NULL,
END_DATE DATE NOT NULL,
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NOT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME,
FOREIGN KEY (ACCOUNTING_ID) REFERENCES RF_ACCOUNTING_ACCOUNTING(ID),
CONSTRAINT UQ_ACC_YR_COD UNIQUE (ACCOUNTING_ID, CODE)
);

CREATE TABLE IF NOT EXISTS RF_ACCOUNTING_LEDGER_ACCOUNTS(
ID INT AUTO_INCREMENT PRIMARY KEY,
CODE VARCHAR(10) NOT NULL,
NAME VARCHAR(30) NOT NULL,
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME,
CONSTRAINT UQ_ACC_LED_ACC_COD UNIQUE (BUSINESS_CUSTOMER_ID, ENTERPRISE_ID, CODE)
);

CREATE TABLE IF NOT EXISTS RF_ACCOUNTING_INVOICE_HEADERS(
ID INT AUTO_INCREMENT PRIMARY KEY,
TYPE TINYINT NOT NULL,
CODE VARCHAR(6) NOT NULL,
NUMBER INT NOT NULL,
DATE_TIME DATETIME NOT NULL,
TOTAL_BASE DECIMAL(18,6) NOT NULL DEFAULT 0,
TOTAL_TAXES DECIMAL(18,6) NOT NULL DEFAULT 0,
TOTAL DECIMAL(18,6) NOT NULL DEFAULT 0,
ACCOUNTING_ID INT NOT NULL,
ACCOUNTING_YEAR_ID INT NOT NULL,
LEDGER_ACCOUNT_ID INT NOT NULL,
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NOT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME,
FOREIGN KEY (ACCOUNTING_ID) REFERENCES RF_ACCOUNTING_ACCOUNTING(ID),
FOREIGN KEY (ACCOUNTING_YEAR_ID) REFERENCES RF_ACCOUNTING_ACCOUNTING_YEARS(ID),
FOREIGN KEY (LEDGER_ACCOUNT_ID) REFERENCES RF_ACCOUNTING_LEDGER_ACCOUNTS(ID),
CONSTRAINT UQ_ACC_INV_HED_COD UNIQUE (ACCOUNTING_ID, ACCOUNTING_YEAR_ID, TYPE, CODE, NUMBER)
);

CREATE INDEX IX_ACC_INV_HED_DATE
ON RF_ACCOUNTING_INVOICE_HEADERS(DATE_TIME, CODE, NUMBER);

CREATE TABLE IF NOT EXISTS RF_ACCOUNTING_INVOICE_LINES(
ID INT AUTO_INCREMENT PRIMARY KEY,
INVOICE_HEADER_ID INT NOT NULL,
LEDGER_ACCOUNT_ID INT NOT NULL,
DATE_TIME DATETIME NOT NULL,
TYPE TINYINT NOT NULL,
NUMBER INT NOT NULL,
DESCRIPTION VARCHAR(300) NOT NULL,
AMOUNT DECIMAL(18,6) NOT NULL DEFAULT 0,
TOTAL DECIMAL(18,6) NOT NULL DEFAULT 0,
TAX_VERSIONS TINYTEXT NULL,
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NOT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME,
FOREIGN KEY (INVOICE_HEADER_ID) REFERENCES RF_ACCOUNTING_INVOICE_HEADERS(ID),
FOREIGN KEY (LEDGER_ACCOUNT_ID) REFERENCES RF_ACCOUNTING_LEDGER_ACCOUNTS(ID),
CONSTRAINT UQ_ACC_INV_LIN_NUM UNIQUE (INVOICE_HEADER_ID, NUMBER)
);

CREATE INDEX IX_ACC_INV_LINE_ORD
ON RF_ACCOUNTING_INVOICE_LINES(INVOICE_HEADER_ID, NUMBER);

CREATE TABLE IF NOT EXISTS RF_ACCOUNTING_SERIES(
ID INT AUTO_INCREMENT PRIMARY KEY,
TYPE TINYINT NOT NULL,
CODE VARCHAR(6) NOT NULL,
NUMBER INT NOT NULL,
NAME VARCHAR(50) NULL,
ACCOUNTING_ID INT NOT NULL,
ACCOUNTING_YEAR_ID INT NOT NULL,
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NOT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME,
FOREIGN KEY (ACCOUNTING_ID) REFERENCES RF_ACCOUNTING_ACCOUNTING(ID),
FOREIGN KEY (ACCOUNTING_YEAR_ID) REFERENCES RF_ACCOUNTING_ACCOUNTING_YEARS(ID),
CONSTRAINT UQ_ACC_SER_TYP_COD UNIQUE (BUSINESS_CUSTOMER_ID, ENTERPRISE_ID, ACCOUNTING_YEAR_ID, TYPE, CODE)
);

CREATE TABLE IF NOT EXISTS RF_ACCOUNTING_ACCOUNTING_YEARS_SERIES(
ID INT AUTO_INCREMENT PRIMARY KEY,
ACCOUNTING_YEAR_ID INT NOT NULL,
TYPE TINYINT NOT NULL,
SERIE_ID INT NOT NULL,
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NOT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME,
FOREIGN KEY (ACCOUNTING_YEAR_ID) REFERENCES RF_ACCOUNTING_ACCOUNTING_YEARS(ID),
CONSTRAINT UQ_ACC_ACC_YR_SER_TYPE UNIQUE (ACCOUNTING_YEAR_ID, TYPE)
);

CREATE TABLE IF NOT EXISTS RF_ACCOUNTING_CONFIGURATIONS(
ID INT AUTO_INCREMENT PRIMARY KEY,
ACCOUNTING_ID INT NULL,
ACCOUNTING_YEAR_ID INT NULL,
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NOT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME,
FOREIGN KEY (ACCOUNTING_ID) REFERENCES RF_ACCOUNTING_ACCOUNTING(ID),
FOREIGN KEY (ACCOUNTING_YEAR_ID) REFERENCES RF_ACCOUNTING_ACCOUNTING_YEARS(ID),
CONSTRAINT UQ_ACC_CONF_BUS_ENT UNIQUE (BUSINESS_CUSTOMER_ID, ENTERPRISE_ID)
);

