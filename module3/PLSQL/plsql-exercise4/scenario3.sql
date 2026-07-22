//Scenario 3: Check Account Balance Availability
CREATE TABLE ACCOUNT(
    ACCOUNT_ID NUMBER PRIMARY KEY,
    BALANCE NUMBER
);
INSERT INTO ACCOUNT VALUES(101,50000);
INSERT INTO ACCOUNT VALUES(102,10000);

COMMIT;
//Function: HasSufficientBalance
CREATE OR REPLACE FUNCTION HasSufficientBalance(
    acc_id NUMBER,
    amount NUMBER
)
RETURN BOOLEAN
IS
    acc_balance NUMBER;
BEGIN

    SELECT BALANCE
    INTO acc_balance
    FROM ACCOUNT
    WHERE ACCOUNT_ID = acc_id;


    IF acc_balance >= amount THEN
        RETURN TRUE;
    ELSE
        RETURN FALSE;
    END IF;

END;
/

//Testing Function:
DECLARE
    result BOOLEAN;
BEGIN

    result := HasSufficientBalance(101,20000);

    IF result THEN
        DBMS_OUTPUT.PUT_LINE('Sufficient Balance');
    ELSE
        DBMS_OUTPUT.PUT_LINE('Insufficient Balance');
    END IF;

END;
/
