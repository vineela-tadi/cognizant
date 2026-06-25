CREATE OR REPLACE PROCEDURE TransferFunds(
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
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
    ELSE
        UPDATE ACCOUNTS
        SET BALANCE = BALANCE - p_amount
        WHERE ACCOUNT_ID = p_from_account;

        UPDATE ACCOUNTS
        SET BALANCE = BALANCE + p_amount
        WHERE ACCOUNT_ID = p_to_account;

        COMMIT;

        DBMS_OUTPUT.PUT_LINE('Funds Transferred Successfully');
    END IF;
END;
/

EXEC TransferFunds(1,2,2000);
SELECT * FROM ACCOUNTS;