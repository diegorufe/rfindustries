
CREATE TABLE IF NOT EXISTS RF_ACCOUNTING_ACCOUNTING(
ID INT AUTO_INCREMENT PRIMARY KEY,
CODE VARCHAR(10),
NAME VARCHAR(30),
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NOT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME
);

CREATE TABLE IF NOT EXISTS RF_ACCOUNTING_ACCOUNTING_YEARS(
ID INT AUTO_INCREMENT PRIMARY KEY,
ACCOUNTING_ID INT NOT NULL,
CODE VARCHAR(4),
NAME VARCHAR(30),
START_DATE DATE NOT NULL,
END_DATE DATE NOT NULL,
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NOT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME,
FOREIGN KEY (ACCOUNTING_ID) REFERENCES RF_ACCOUNTING_ACCOUNTING(ID)
);

CREATE TABLE IF NOT EXISTS RF_ACCOUNTING_TAXES(
ID INT AUTO_INCREMENT PRIMARY KEY,
CODE VARCHAR(10),
NAME VARCHAR(30),
START_DATE DATE NOT NULL,
BUSINESS_CUSTOMER_ID INT NOT NULL,
ENTERPRISE_ID INT NOT NULL,
USER_CREATED_AT_ID INT,
USER_UPDATED_AT_ID INT,
CREATED_AT DATETIME,
UPDATED_AT DATETIME
);