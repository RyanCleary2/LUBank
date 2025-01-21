INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L001', a.id, c.id, cust.id, 5000.00, TO_DATE('2025-05-01', 'YYYY-MM-DD'), 5.00 
FROM (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account)) a,
     (SELECT id FROM card) c,
     (SELECT id, name FROM customer) cust
WHERE ROWNUM = 1;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L002', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                NULL, 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                3500.00, 
                TO_DATE('2026-06-01', 'YYYY-MM-DD'), 
                4.75
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L003', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM card ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                4500.00, 
                TO_DATE('2024-07-15', 'YYYY-MM-DD'), 
                6.50
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L004', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                NULL, 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                2900.00, 
                TO_DATE('2026-08-01', 'YYYY-MM-DD'), 
                5.50
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L005', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM card ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                3700.00, 
                TO_DATE('2025-09-20', 'YYYY-MM-DD'), 
                5.25
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L006', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                NULL, 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                2300.00, 
                TO_DATE('2027-01-15', 'YYYY-MM-DD'), 
                4.85
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L007', a.id, c.id, cust.id, 4200.00, TO_DATE('2024-11-30', 'YYYY-MM-DD'), 5.30 
FROM (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account)) a,
     (SELECT id FROM card) c,
     (SELECT id, name FROM customer) cust
WHERE ROWNUM = 1;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L008', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM card ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                3400.00, 
                TO_DATE('2025-12-25', 'YYYY-MM-DD'), 
                6.00
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L009', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                NULL, 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                2800.00, 
                TO_DATE('2026-10-10', 'YYYY-MM-DD'), 
                5.15
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L010', a.id, c.id, cust.id, 5500.00, TO_DATE('2025-03-15', 'YYYY-MM-DD'), 4.95 
FROM (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account)) a,
     (SELECT id FROM card) c,
     (SELECT id, name FROM customer) cust
WHERE ROWNUM = 1;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L011', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM card ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                4900.00, 
                TO_DATE('2026-06-15', 'YYYY-MM-DD'), 
                5.75
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L012', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                NULL, 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                1500.00, 
                TO_DATE('2027-05-15', 'YYYY-MM-DD'), 
                4.70
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L013', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM card ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                3700.00, 
                TO_DATE('2024-02-14', 'YYYY-MM-DD'), 
                5.60
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L014', a.id, NULL, cust.id, 4200.00, TO_DATE('2024-08-30', 'YYYY-MM-DD'), 4.85 
FROM (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account)) a,
     (SELECT id, name FROM customer) cust
WHERE ROWNUM = 1;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L015', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM card ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                4800.00, 
                TO_DATE('2025-03-20', 'YYYY-MM-DD'), 
                5.10
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L016', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                NULL, 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                5600.00, 
                TO_DATE('2026-04-01', 'YYYY-MM-DD'), 
                6.20
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L017', a.id, c.id, cust.id, 2900.00, TO_DATE('2025-01-15', 'YYYY-MM-DD'), 5.40 
FROM (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account)) a,
     (SELECT id FROM card) c,
     (SELECT id, name FROM customer) cust
WHERE ROWNUM = 1;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L018', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM card ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                3500.00, 
                TO_DATE('2026-02-10', 'YYYY-MM-DD'), 
                5.60
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L019', (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account) ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                NULL, 
                (SELECT id FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
                4800.00, 
                TO_DATE('2027-03-10', 'YYYY-MM-DD'), 
                4.90
FROM dual;

INSERT INTO loan(id, account, card, customer, balance, payment_due, interest_rate) 
SELECT 'L020', a.id, c.id, cust.id, 2300.00, TO_DATE('2025-07-30', 'YYYY-MM-DD'), 5.15 
FROM (SELECT id FROM account WHERE id NOT IN (SELECT id FROM investment_account)) a,
     (SELECT id FROM card) c,
     (SELECT id, name FROM customer) cust
WHERE ROWNUM = 1;


