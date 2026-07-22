SET SERVEROUTPUT ON;

BEGIN
   FOR c IN (
      SELECT CUSTOMER_ID, AGE
      FROM CUSTOMERS
   )
   LOOP
      IF c.AGE > 60 THEN
         UPDATE CUSTOMERS
         SET INTEREST_RATE = INTEREST_RATE - 1
         WHERE CUSTOMER_ID = c.CUSTOMER_ID;

         DBMS_OUTPUT.PUT_LINE(
            'Discount applied to Customer ID: ' || c.CUSTOMER_ID
         );
      END IF;
   END LOOP;

   COMMIT;
END;
/