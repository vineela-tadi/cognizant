//Scenario 2: Calculate Monthly Loan Installment (EMI)
//Function: CalculateMonthlyInstallment
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
    loan_amount NUMBER,
    interest_rate NUMBER,
    duration_years NUMBER
)
RETURN NUMBER
IS
    monthly_rate NUMBER;
    months NUMBER;
    emi NUMBER;
BEGIN

    monthly_rate := interest_rate / 12 / 100;
    months := duration_years * 12;

    emi := (loan_amount * monthly_rate * POWER(1 + monthly_rate, months)) /
           (POWER(1 + monthly_rate, months) - 1);

    RETURN ROUND(emi,2);

END;
/

//Calling the function:
SELECT CalculateMonthlyInstallment(500000,8,5) AS MONTHLY_EMI
FROM DUAL;