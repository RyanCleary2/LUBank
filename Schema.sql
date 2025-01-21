create table customer
    (id varchar(5),
    name varchar(20) not null,
    phone_number numeric(10, 0),
    birthday date,
    address varchar(50),
    primary key(id));
    
create table account
    (id varchar(5),
    customer_id varchar(5) references customer(id),
    balance numeric(9, 2),
    primary key(id));
    
create table savings_account
    (id varchar(5) references account(id),
    min_balance numeric(6,2),
    interest_rate numeric(2,2),
    primary key(id));
    
create table checking_account
    (id varchar(5) references account(id),
    overdraft_fee numeric(4, 2),
    primary key(id));
    
create table investment_account 
    (id varchar(5) references account(id),
    tot_assets numeric(9, 2),
    primary key(id));
    
create table assets
    (id varchar(5),
    investment_account varchar(5) references investment_account(id),
    value numeric(9,2),
    primary key(id));

create table card
    (id numeric(16, 0),
    account varchar(5) references account(id),
    customer varchar(5) references customer(id),
    cardholder varchar(20),
    exp_date date,
    ccv numeric(3,0),
    primary key(id));
    
create table credit
    (id numeric(16, 0) references card(id),
    interest_rate numeric(2,2),
    credit_limit numeric(6,2),
    balance_due numeric(6,2),
    min_payment numeric(6,2),
    primary key (id));
    
create table debit 
    (id numeric(16, 0) references card(id),
    pin numeric(4,0),
    primary key(id));
    
create table loan
    (id varchar(5),
    account varchar(5) references account(id),
    card numeric(16, 0) references card(id),
    customer varchar(5) references customer(id),
    balance numeric(9,2),
    payment_due date,
    interest_rate numeric(2,2),
    primary key(id));
    
create table secure_loan
    (id varchar(5) references loan(id),
    address varchar(20),
    property_value numeric(9,2),
    primary key(id));
    
create table transaction
    (id varchar(5),
    sender varchar(16),
    reciepient varchar(16),
    amount numeric(9,2),
    transaction_date date,
    primary key (id));
    
create table repayment
    (id varchar(5) references transaction(id),
    min_repayment numeric(8, 2),
     primary key(id));
    
create table transfer
    (id varchar(5) references transaction(id),
    message varchar(50),
     primary key(id));
    
create table ATM
    (id varchar(16) references transaction(id),
    zip_code varchar(5),
     primary key(id));
     
INSERT INTO ATM (id, zip_code) 

SELECT * FROM account WHERE customer = '04049';

ALTER TABLE transaction MODIFY sender VARCHAR(16);
ALTER TABLE transaction MODIFY reciepient VARCHAR(16);

CREATE SEQUENCE loan_seq
START WITH 21       -- The starting value of the sequence
INCREMENT BY 1     -- The value by which the sequence will increment
NOCACHE; 
DROP SEQUENCE loan_seq;
select * from loan;

select * from ATM;
select * from repayment;
select * from transfer;

