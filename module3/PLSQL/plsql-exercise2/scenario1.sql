//Scenario 1: SafeTransferFunds
// Accounts Table
CREATE TABLE ACCOUNTS (
    ACCOUNT_ID NUMBER PRIMARY KEY,
    BALANCE NUMBER
);

INSERT INTO ACCOUNTS VALUES (1,10000);
INSERT INTO ACCOUNTS VALUES (2,5000);

COMMIT;

// Procedure
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    p_from_account NUMBER,
    p_to_account NUMBER,
    p_amount NUMBER
)
IS
    v_balance NUMBER;
BEGIN
    SELECT BALANCE
    INTO v_balance
    FROM ACCOUNTS
    WHERE ACCOUNT_ID = p_from_account;

    IF v_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001,'Insufficient Funds');
    END IF;

    UPDATE ACCOUNTS
    SET BALANCE = BALANCE - p_amount
    WHERE ACCOUNT_ID = p_from_account;

    UPDATE ACCOUNTS
    SET BALANCE = BALANCE + p_amount
    WHERE ACCOUNT_ID = p_to_account;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Funds Transferred Successfully');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

// Execute
EXEC SafeTransferFunds(1,2,2000);

//verification
SELECT * FROM ACCOUNTS;