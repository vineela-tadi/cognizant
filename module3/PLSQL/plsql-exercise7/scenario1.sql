//Scenario 1: CustomerManagement Package
CREATE OR REPLACE PACKAGE CustomerManagement AS

    PROCEDURE AddCustomer(
        p_customer_id NUMBER,
        p_age NUMBER,
        p_interest_rate NUMBER,
        p_balance NUMBER,
        p_isvip VARCHAR2
    );

    PROCEDURE UpdateCustomer(
        p_customer_id NUMBER,
        p_balance NUMBER
    );

    FUNCTION GetCustomerBalance(
        p_customer_id NUMBER
    ) RETURN NUMBER;

END CustomerManagement;
/

CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

    PROCEDURE AddCustomer(
        p_customer_id NUMBER,
        p_age NUMBER,
        p_interest_rate NUMBER,
        p_balance NUMBER,
        p_isvip VARCHAR2
    )
    IS
    BEGIN
        INSERT INTO Customers
        VALUES(
            p_customer_id,
            p_age,
            p_interest_rate,
            p_balance,
            p_isvip
        );
    END;

    PROCEDURE UpdateCustomer(
        p_customer_id NUMBER,
        p_balance NUMBER
    )
    IS
    BEGIN
        UPDATE Customers
        SET Balance = p_balance
        WHERE Customer_ID = p_customer_id;
    END;

    FUNCTION GetCustomerBalance(
        p_customer_id NUMBER
    )
    RETURN NUMBER
    IS
        v_balance NUMBER;
    BEGIN

        SELECT Balance
        INTO v_balance
        FROM Customers
        WHERE Customer_ID = p_customer_id;

        RETURN v_balance;

    END;

END CustomerManagement;
/

SELECT CustomerManagement.GetCustomerBalance(101)
FROM DUAL;
SELECT * FROM Customers;

SELECT CustomerManagement.GetCustomerBalance(1)
FROM DUAL;