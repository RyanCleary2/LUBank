INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (8594623471623057, '82685', '87207', 'Abbie Castellani', TO_DATE('2025-10-30', 'YYYY-MM-DD'), 185);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (4579201865312410, '06034', '83834', 'Talya Michurin', TO_DATE('2026-09-04', 'YYYY-MM-DD'), 805);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (3718460295837204, '63120', '19060', 'Dieter Lindenstrauss', TO_DATE('2024-08-21', 'YYYY-MM-DD'), 509);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (2876342154895203, '49158', '30609', 'Zelig Futty', TO_DATE('2024-01-31', 'YYYY-MM-DD'), 267);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (9836425071918463, '80668', '76686', 'Ginger Stallen', TO_DATE('2026-03-27', 'YYYY-MM-DD'), 809);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (2163849571028394, '18884', '64191', 'Artemas Hain', TO_DATE('2023-11-15', 'YYYY-MM-DD'), 153);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (6458290173261549, '41811', '36650', 'Elspeth Silcocks', TO_DATE('2024-07-10', 'YYYY-MM-DD'), 466);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (3781564298740512, '44018', '25204', 'Kariotta Tabbitt', TO_DATE('2024-01-10', 'YYYY-MM-DD'), 410);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (1526473095841729, '35712', '06270', 'Dolf Dymott', TO_DATE('2025-11-15', 'YYYY-MM-DD'), 937);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (8379514268043256, '98817', '98117', 'Hendrik Wisbey', TO_DATE('2027-07-21', 'YYYY-MM-DD'), 482);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (4652938171042637, '24700', '90609', 'Georgy Castanie', TO_DATE('2026-06-27', 'YYYY-MM-DD'), 102);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (7948265019345602, '97724', '35249', 'Dannel Kindley', TO_DATE('2026-07-02', 'YYYY-MM-DD'), 46);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (1829476503178264, '83462', '90609', 'Georgy Castanie', TO_DATE('2027-07-19', 'YYYY-MM-DD'), 60);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (3402165798401472, '29516', '36650', 'Elspeth Silcocks', TO_DATE('2026-04-15', 'YYYY-MM-DD'), 831);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (7923548619025731, '00322', '73211', 'Kassia Fyfield', TO_DATE('2025-07-30', 'YYYY-MM-DD'), 266);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (1586243074956830, '82093', '15836', 'Mellicent Waldie', TO_DATE('2026-11-08', 'YYYY-MM-DD'), 919);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (3129875467204639, '04186', '64191', 'Artemas Hain', TO_DATE('2026-07-31', 'YYYY-MM-DD'), 437);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (6142790381564078, '10341', '76686', 'Ginger Stallen', TO_DATE('2026-12-24', 'YYYY-MM-DD'), 331);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (7962841538920671, '13136', '07594', 'Idalia Ledram', TO_DATE('2027-09-19', 'YYYY-MM-DD'), 545);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (9075426813742653, '71597', '98312', 'Rob Tressler', TO_DATE('2025-09-11', 'YYYY-MM-DD'), 790);
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (70108, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2025-05-27', 'YYYY-MM-DD'), 712);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (45489, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2027-02-02', 'YYYY-MM-DD'), 553);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (96324, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2027-02-03', 'YYYY-MM-DD'), 153);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (21334, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2024-10-12', 'YYYY-MM-DD'), 951);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (23598, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2024-08-14', 'YYYY-MM-DD'), 888);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (57178, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2023-12-03', 'YYYY-MM-DD'), 711);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (49331, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2026-04-19', 'YYYY-MM-DD'), 710);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (9524, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2026-11-30', 'YYYY-MM-DD'), 456);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (60544, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2026-12-06', 'YYYY-MM-DD'), 864);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (78080, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2026-12-05', 'YYYY-MM-DD'), 430);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (54896, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2024-07-02', 'YYYY-MM-DD'), 903);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (52403, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2024-10-04', 'YYYY-MM-DD'), 585);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (42147, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2024-02-29', 'YYYY-MM-DD'), 731);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (63080, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2026-11-12', 'YYYY-MM-DD'), 52);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (96235, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2025-04-09', 'YYYY-MM-DD'), 712);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (81544, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2024-01-08', 'YYYY-MM-DD'), 874);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (26814, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2027-08-20', 'YYYY-MM-DD'), 254);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (99384, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2026-11-26', 'YYYY-MM-DD'), 257);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (10658, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2027-09-16', 'YYYY-MM-DD'), 117);

INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (81333, NULL, 
    (SELECT ID FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    (SELECT NAME FROM customer ORDER BY DBMS_RANDOM.VALUE FETCH FIRST 1 ROWS ONLY), 
    TO_DATE('2027-03-01', 'YYYY-MM-DD'), 982);
    
INSERT INTO card(id, account, customer, cardholder, exp_date, ccv) VALUES (1234567890113333, '00001', '04049', 'Luigi Grzegorzewicz', TO_DATE('2025-09-11', 'YYYY-MM-DD'), 790);

SELECT balance FROM account WHERE id = (SELECT card.account FROM debit join card on debit.id = card.id WHERE id = ?);

Select * from transaction;
select * from card;
delete from card where id = '11111111111111';