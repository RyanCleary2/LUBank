README for Final Project 

Important use customer ID 04049 "Luigi" to robustly test all features

Hello all users, 

After launching my program and connecting to the database you will be greeted to choose :

Either the [1] Bank Manager or [2] Customer Role

[1] Bank Manager has the ability to 
    [1] Compute total loans
        View Total Dollar amount of all the loans in the bank's database
    [2] Compute total accounts
        View Total Dollar amount of all the accounts in the bank's database
    [3] Compute totals on a per-customer basis
        View a List of Customers, select one and view the amount they hold in their accounts and total loans 
    [4] Compute transaction frequency and dollar volume (per day, month, year)
        View the metrics of the transactions with it being displayed by day, month, and year
        Without any GUI implementation is it more or less text wall that is seperated by period 

All of these are pretty straighforward and the only interface that requires input is veiwing the customer metrics 

[2] Customer Role has the ability to 
    [1] Deposit
        Select any account and insert money (It is assumed that this is a cash to teller transaction)
        I decided to represent this as a transaction with no sender account 
        I did not make a unique specialization for this because I can easily query all the transactions w/o senders if needed 
    [2] Withdraw
        Similarly to Deposit, it is represented as a transaction without a recipient 

        I made a specialization for this because I made in on my erd and if I had played around more with the internal controls of the database I think it would've been easier to limit the accounts that can do this

        You can use any card for this withdraw (I had to google that I don't have a credit card) and only the savings and checking accounts are affected because we are assuming this is at an ATM

        Also this enforces the fact that the checking account cannot go below 0

    [3] Repayment on loan or credit card
        This interface gave me the most trouble but I ultimately shows the user all the loans and the credit cards that they can repay. I only ended up requiring min payments on the credit cards because my bank is greedy and we are ok with our customers building up more interest.

        After seeing the avalible cards and accounts the user chooses to either repay a credit or loan (this helped me not write headache worthy queries) and then enteres the amount that they want to pay 

        If the loan reaches 0 on the balance it is removed 

    [4] Take out new loan
        This one is pretty straightforward and takes out a now loan with monthly payment set to a month from the current day. There is no verification becuase we are a shady bank and using our customer interface it is tied to the customer and their association acounts are availible to pay it automatically.
        
        If I had more time I would require that they register a repayment method however I am short on that and this feels adequet for now.

    [5] Purchase using card
        This one allows for the user to spend money with just a few simple clicks

        Shows all the cards belonging to the customer and you can select one and the amount of the purchase 

        I'm not sure how we were supposed to keep track of the entities for this one so the recipient is blank, but I recorded those transactions into transfer and there is a message that says it was from a vendor so I hope that it's enough 

TESTING 

All the data entry is verified so no errors should occur

It should be pretty straightforward with the manager 

When I was testing the Customer I decided to elect what I like to call "THE PERFECT CUSTOMER"
His ID is 04049 and his name is Luigi (that was randomly generated)

He has everything you would want in a tester with multiple loans, a credit card, and debit card (this is mainly because I used a fairly low ratio between customer, account, and card sample data so I manually created luigi's features)

Important things to note his credit card is 1234567890112222 and his debit card is 1234567890113333
His checking account is 00001 and his savings account is 00002, account 00003 is investment (I didn't implemement much for that)

REVIEWING THE CODE

I apologize for it not being super modualarized. I ended up dedicating my time towards other deadlines and aimed to implement the functionality. Also I will not likely deploy, revise, or continue improving this code so I will remain as is.

I have Added Comments at the beginning of each interface so in the hopefully unlikely case that you need to look through anything I added //START OF comments to navigate to each interface if you are trying to see what was broken.

END OF README