//Scenario 3: Enforce business rules on deposits and withdrawals
CREATE TABLE Accounts(
    Account_ID NUMBER PRIMARY KEY,
    Balance NUMBER
);
DESC Accounts;
SELECT * FROM Accounts;

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW

DECLARE
    current_balance NUMBER;

BEGIN

    SELECT Balance
    INTO current_balance
    FROM Accounts
    WHERE Account_ID = :NEW.Account_ID;


    IF :NEW.Transaction_Type = 'DEPOSIT'
    AND :NEW.Amount <= 0 THEN

        RAISE_APPLICATION_ERROR(
        -20001,
        'Deposit amount must be positive'
        );

    END IF;


    IF :NEW.Transaction_Type = 'WITHDRAWAL'
    AND :NEW.Amount > current_balance THEN

        RAISE_APPLICATION_ERROR(
        -20002,
        'Insufficient balance'
        );

    END IF;

END;
/

INSERT INTO Accounts
VALUES(101,10000);

COMMIT;
SELECT * FROM Accounts;
INSERT INTO Transactions
VALUES(2,101,'DEPOSIT',5000);
SELECT * FROM Transactions;