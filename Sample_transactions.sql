INSERT INTO transaction (id, sender, reciepient, amount, transaction_date) VALUES 
('T001', 
 (SELECT id FROM account ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY),  -- Random sender account
 (SELECT id FROM account ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY),  -- Random recipient account
 100.00, 
 SYSDATE
);

INSERT INTO transaction (id, sender, reciepient, amount, transaction_date) VALUES 
('T002', 
 (SELECT id FROM account ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY),  -- Random sender account
 (SELECT id FROM loan ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY),    -- Random recipient loan
 200.00, 
 SYSDATE
);

INSERT INTO transaction (id, sender, reciepient, amount, transaction_date) VALUES 
('T003', 
 (SELECT id FROM loan ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY),    -- Random sender loan
 (SELECT id FROM account ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY),  -- Random recipient account
 300.00, 
 SYSDATE
);

INSERT INTO transaction (id, sender, reciepient, amount, transaction_date) VALUES 
('T004', 
 (SELECT id FROM account ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY),  -- Random sender account
 (SELECT id FROM loan ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY),    -- Random recipient loan
 400.00, 
 SYSDATE
);

INSERT INTO transaction (id, sender, reciepient, amount, transaction_date) VALUES 
('T005', 
 (SELECT id FROM account ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY),  -- Random sender account
 (SELECT id FROM account ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY),  -- Random recipient account
 150.00, 
 SYSDATE
);

