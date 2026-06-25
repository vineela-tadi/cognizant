//Scenario 3: AccountOperations Package
DESC Accounts;

CREATE OR REPLACE PACKAGE AccountOperations AS

    PROCEDURE OpenAccount(
        p_account_id NUMBER,
        p_balance NUMBER
    );

    PROCEDURE CloseAccount(
        p_account_id NUMBER
    );

    FUNCTION GetTotalBalance(
        p_account_id NUMBER
    ) RETURN NUMBER;

END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenAccount(
        p_account_id NUMBER,
        p_balance NUMBER
    )
    IS
    BEGIN
        INSERT INTO Accounts(Account_ID, Balance)
        VALUES(p_account_id, p_balance);
    END;

    PROCEDURE CloseAccount(
        p_account_id NUMBER
    )
    IS
    BEGIN
        DELETE FROM Accounts
        WHERE Account_ID = p_account_id;
    END;

    FUNCTION GetTotalBalance(
        p_account_id NUMBER
    )
    RETURN NUMBER
    IS
        v_balance NUMBER;
    BEGIN

        SELECT Balance
        INTO v_balance
        FROM Accounts
        WHERE Account_ID = p_account_id;

        RETURN v_balance;

    END;

END AccountOperations;
/

BEGIN
    AccountOperations.OpenAccount(
        999,
        25000
    );
END;
/

SELECT * FROM Accounts;

SELECT AccountOperations.GetTotalBalance(999)
FROM DUAL;