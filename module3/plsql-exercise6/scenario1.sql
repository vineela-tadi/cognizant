//Scenario 1: Generate monthly statements for all customers
SELECT * FROM Transactions;
DESC Transactions;
ALTER TABLE Transactions
ADD Transaction_Date DATE;
UPDATE Transactions
SET Transaction_Date = SYSDATE;
COMMIT;
DESC Customers;  
SET SERVEROUTPUT ON;
DECLARE

    CURSOR GenerateMonthlyStatements IS
    SELECT 
        c.CUSTOMER_ID,
        t.TRANSACTION_ID,
        t.TRANSACTION_TYPE,
        t.AMOUNT,
        t.TRANSACTION_DATE
    FROM Customers c
    JOIN Transactions t
    ON c.CUSTOMER_ID = t.ACCOUNT_ID
    WHERE EXTRACT(MONTH FROM t.TRANSACTION_DATE) = EXTRACT(MONTH FROM SYSDATE)
    AND EXTRACT(YEAR FROM t.TRANSACTION_DATE) = EXTRACT(YEAR FROM SYSDATE);


BEGIN

    FOR rec IN GenerateMonthlyStatements
    LOOP

        DBMS_OUTPUT.PUT_LINE(
            'Customer ID: ' || rec.CUSTOMER_ID ||
            ' | Transaction ID: ' || rec.TRANSACTION_ID ||
            ' | Type: ' || rec.TRANSACTION_TYPE ||
            ' | Amount: ' || rec.AMOUNT
        );

    END LOOP;

END;
/
