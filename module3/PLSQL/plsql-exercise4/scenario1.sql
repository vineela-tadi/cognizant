//Scenario 1: Calculate customer age using Date of Birth
//Function: CalculateAge
CREATE OR REPLACE FUNCTION CalculateAge(
    dob DATE
)
RETURN NUMBER
IS
    age NUMBER;
BEGIN
    age := TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12);

    RETURN age;
END;
/

//Calling the function:
SELECT CalculateAge(TO_DATE('15-08-2002','DD-MM-YYYY')) AS AGE
FROM DUAL;