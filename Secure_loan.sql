INSERT INTO secure_loan(id, address, property_value)
SELECT 
    l.id, 
    'Address ' || ROWNUM AS address,  -- This will create a simple address format
    ROUND(DBMS_RANDOM.VALUE(150000, 500000), 2) AS property_value  -- Random property value between 150k and 500k
FROM 
    (SELECT id FROM loan ORDER BY DBMS_RANDOM.VALUE) l
WHERE ROWNUM <= 10;
