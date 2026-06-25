//Scenario 3: AddNewCustomer
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    p_customer_id NUMBER,
    p_age NUMBER,
    p_interest_rate NUMBER,
    p_balance NUMBER,
    p_isvip VARCHAR2
)
IS
BEGIN
    INSERT INTO CUSTOMERS
    VALUES(
        p_customer_id,
        p_age,
        p_interest_rate,
        p_balance,
        p_isvip
    );

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Customer Added Successfully');

EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
        DBMS_OUTPUT.PUT_LINE(
            'Error: Customer ID already exists'
        );
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE(
            'Error: ' || SQLERRM
        );
END;
/

//execute
EXEC AddNewCustomer(10,30,12,15000,'FALSE');

//verification
SELECT * FROM CUSTOMERS;