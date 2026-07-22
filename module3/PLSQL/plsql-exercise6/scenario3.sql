DESC Loans;
INSERT INTO Loans VALUES(1,101,9);
INSERT INTO Loans VALUES(2,102,7);

COMMIT;
ALTER TABLE Loans
ADD Interest_Rate NUMBER;

UPDATE Loans
SET Interest_Rate = 9
WHERE Loan_ID = 1;

UPDATE Loans
SET Interest_Rate = 7
WHERE Loan_ID = 2;

COMMIT;

SELECT * FROM Loans;
DECLARE

    CURSOR UpdateLoanInterestRates IS
    SELECT Loan_ID, Interest_Rate
    FROM Loans;

BEGIN

    FOR loan IN UpdateLoanInterestRates
    LOOP

        IF loan.Interest_Rate > 8 THEN

            UPDATE Loans
            SET Interest_Rate = 7.5
            WHERE Loan_ID = loan.Loan_ID;

        ELSE

            UPDATE Loans
            SET Interest_Rate = 6.5
            WHERE Loan_ID = loan.Loan_ID;

        END IF;

    END LOOP;

    COMMIT;

END;
/