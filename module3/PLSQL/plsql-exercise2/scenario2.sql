//Scenario 2: UpdateSalary
//Employees Table
CREATE TABLE EMPLOYEES (
    EMP_ID NUMBER PRIMARY KEY,
    EMP_NAME VARCHAR2(50),
    SALARY NUMBER
);
INSERT INTO EMPLOYEES VALUES (101,'Ravi',30000);
INSERT INTO EMPLOYEES VALUES (102,'Sita',40000);

COMMIT;

//Procedure
CREATE OR REPLACE PROCEDURE UpdateSalary(
    p_emp_id NUMBER,
    p_percentage NUMBER
)
IS
BEGIN
    UPDATE EMPLOYEES
    SET SALARY = SALARY + (SALARY * p_percentage/100)
    WHERE EMP_ID = p_emp_id;

    IF SQL%ROWCOUNT = 0 THEN
        RAISE_APPLICATION_ERROR(-20002,'Employee ID Not Found');
    END IF;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Salary Updated Successfully');

EXCEPTION
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END;
/

//Execute
EXEC UpdateSalary(101,10);

//verification
SELECT * FROM EMPLOYEES;