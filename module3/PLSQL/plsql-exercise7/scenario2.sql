CREATE TABLE Employees(
    Employee_ID NUMBER PRIMARY KEY,
    Employee_Name VARCHAR2(50),
    Monthly_Salary NUMBER
);

SELECT * FROM Employees;


SELECT OBJECT_NAME, OBJECT_TYPE
FROM USER_OBJECTS
WHERE OBJECT_NAME = 'EMPLOYEEMANAGEMENT';
CREATE OR REPLACE PACKAGE EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER
    );

    PROCEDURE UpdateEmployee(
        p_id NUMBER,
        p_salary NUMBER
    );

    FUNCTION CalculateAnnualSalary(
        p_id NUMBER
    ) RETURN NUMBER;

END EmployeeManagement;
/

CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

    PROCEDURE HireEmployee(
        p_id NUMBER,
        p_name VARCHAR2,
        p_salary NUMBER
    )
    IS
    BEGIN
        INSERT INTO Employees
        (EMP_ID, EMP_NAME, SALARY)
        VALUES
        (p_id, p_name, p_salary);
    END;

    PROCEDURE UpdateEmployee(
        p_id NUMBER,
        p_salary NUMBER
    )
    IS
    BEGIN
        UPDATE Employees
        SET SALARY = p_salary
        WHERE EMP_ID = p_id;
    END;

    FUNCTION CalculateAnnualSalary(
        p_id NUMBER
    )
    RETURN NUMBER
    IS
        v_salary NUMBER;
    BEGIN

        SELECT SALARY * 12
        INTO v_salary
        FROM Employees
        WHERE EMP_ID = p_id;

        RETURN v_salary;

    END;

END EmployeeManagement;
/

DESC Employees;
BEGIN
    EmployeeManagement.HireEmployee(
        101,
        'GANESH',
        50000
    );
END;
/
SELECT * FROM Employees;
SELECT EmployeeManagement.CalculateAnnualSalary(101)
FROM DUAL;