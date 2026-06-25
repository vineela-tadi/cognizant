//Scenario 1: Update Last Modified Date when Customer Record is Updated
CREATE TABLE Customers(
    Customer_ID NUMBER PRIMARY KEY,
    Customer_Name VARCHAR2(50),
    Balance NUMBER,
    LastModified DATE
);
SELECT table_name 
FROM user_tables
WHERE table_name = 'CUSTOMERS';
DESC Customers;

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW

BEGIN

    :NEW.LastModified := SYSDATE;

END;
/
UPDATE Customers
SET Balance = 50000
WHERE Customer_ID = 101;

SELECT * FROM Customers;