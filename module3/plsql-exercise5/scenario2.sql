//Scenario 2: Maintain Audit Log for Transactions
CREATE TABLE Transactions(
    Transaction_ID NUMBER PRIMARY KEY,
    Account_ID NUMBER,
    Transaction_Type VARCHAR2(20),
    Amount NUMBER
);

CREATE TABLE AuditLog(
    Log_ID NUMBER,
    Transaction_ID NUMBER,
    Action_Date DATE
);

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW

BEGIN

    INSERT INTO AuditLog
    VALUES(
        Audit_Seq.NEXTVAL,
        :NEW.Transaction_ID,
        SYSDATE
    );

END;
/

INSERT INTO Transactions
VALUES(1,101,'DEPOSIT',5000);

SELECT * FROM AuditLog;