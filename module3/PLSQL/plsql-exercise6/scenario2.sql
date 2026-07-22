DECLARE

    CURSOR ApplyAnnualFee IS
    SELECT Account_ID, Balance
    FROM Accounts;

    annual_fee NUMBER := 500;

BEGIN

    FOR acc IN ApplyAnnualFee
    LOOP

        UPDATE Accounts
        SET Balance = Balance - annual_fee
        WHERE Account_ID = acc.Account_ID;

    END LOOP;

    COMMIT;

END;
/
SELECT * FROM Accounts;