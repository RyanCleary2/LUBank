/*Final Project for CSE 241 : LUBANK Simulated Bank Database 
 * Ryan Cleary 
*/

import java.sql.* ;
import java.util.Scanner;  

public class LUBank{
    public static void main(String[] args){

        //For User Input 
        Scanner scan = new Scanner(System.in);

        String oracle_id = "";
        String oracle_password = "";
        boolean validUser = false;
        //Login Loop for getting into edgar1
        while (!validUser) {
            System.out.println("enter Oracle user id (or type 'exit' to quit):");
            oracle_id = scan.nextLine();
            if (oracle_id.equalsIgnoreCase("exit")) {
            System.out.println("Exiting program.");
            System.exit(0);
            }

            System.out.println("enter Oracle password for dbcourse:");
            oracle_password = scan.nextLine();
            if (oracle_password.equalsIgnoreCase("exit")) {
            System.out.println("Exiting program.");
            System.exit(0);
            }

            try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241", oracle_id, oracle_password)) {
            validUser = true;
            } catch (SQLException e) {
            System.out.println("Invalid Oracle user id or password. Please try again.");
            }
        }

        //Main Loop for the program after the user has logged in
        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@edgar1.cse.lehigh.edu:1521:cse241", oracle_id, oracle_password);
            Statement stmt = conn.createStatement();)
            {
                boolean loop = true;
                while(loop){
                    //Roles for the assignment 
                    //Manger fufills interface 1 
                    //Customer fufills interface 2, 3, 6, 7
                    System.out.println("Input the role you would like to use:");
                    System.out.println("[1] Bank Manager");
                    System.out.println("[2] Customer");
                    System.out.println("[0] to exit:");
                    
                    //For each input I take it and validate that its the correct type and the range is what I 
                    //would expect it to be, then I run the query and check that the year is in the dataset
                    //I am pretty sure everything flows with the validation and doesn't terminate 

                    int choice = 0;
                    if (scan.hasNextInt()) {
                        choice = scan.nextInt();
                        scan.nextLine(); 
                        if (choice == 0) {
                            loop = false;
                            break;
                        } else if (choice < 0 || choice > 2) {
                            System.out.println("Invalid input. Please enter a valid role.");
                            continue;
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a numeric year.");
                        scan.next();  
                    }

                    /* START OF MANAGER INTERFACE  */
                    if (choice == 1) {
                        boolean managerLoop = true;
                        while (managerLoop) {
                            //Interface for the manager tells user options
                            System.out.println("Welcome Bank Manager:");
                            System.out.println("[1] Compute total loans");
                            System.out.println("[2] Compute total accounts");
                            System.out.println("[3] Compute totals on a per-customer basis");
                            System.out.println("[4] Compute transaction frequency and dollar volume (per day, month, year)");
                            System.out.println("[0] to return to the main menu");

                            //Verify that the input is correct and in the range of the options
                            int managerChoice = 0;
                            if (scan.hasNextInt()) {
                                managerChoice = scan.nextInt();
                                scan.nextLine();
                                if (managerChoice == 0) {
                                    managerLoop = false;
                                    break;
                                } else if (managerChoice < 0 || managerChoice > 4) {
                                    System.out.println("Invalid input. Please enter a valid option.");
                                    continue;
                                }
                            } else {
                                System.out.println("Invalid input. Please enter a numeric option.");
                                scan.next();
                                continue;
                            }
                            switch (managerChoice) {
                                /* START OF TOTAL LOANS INTERFACE  */
                                case 1:
                                    // Compute total loans
                                    System.out.println("Computing total loans: ");
                                    String query = "Select SUM(balance) FROM loan";
                                    try (ResultSet rs = stmt.executeQuery(query)) {
                                        if (!rs.next()) {
                                            System.out.println("Something went wrong! OH GOD NO");
                                            continue;
                                        }
                                        System.out.println("Total loans: " + rs.getInt(1));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                /* START OF TOTAL ACCOUNTS INTERFACE  */
                                case 2:
                                    // Compute total accounts
                                    System.out.println("Computing total accounts: ");
                                    query = "Select COUNT(*) FROM account";
                                    try (ResultSet rs = stmt.executeQuery(query)) {
                                        if (!rs.next()) {
                                            System.out.println("Something went wrong! OH GOD NO");
                                            continue;
                                        }
                                        System.out.println("Total Accounts: " + rs.getInt(1));
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                /* START OF TOTAL PER CUSTOMER INTERFACE  */
                                case 3:
                                    // Compute totals on a per-customer basis
                                    System.out.println("Computing totals on a per-customer basis: ");
                                    //Padding bc when I try using varchar w/o exist char it doesn't work
                                    query = "SELECT LPAD(id, 5, '0') AS id FROM customer";
                                    try (ResultSet rs = stmt.executeQuery(query)) {
                                        String customerIds = "";
                                        //Lisitng all the customer ids
                                        while (rs.next()) {
                                            customerIds += rs.getString("id") + " ";
                                        }
                                        if (customerIds.isEmpty()) {
                                            System.out.println("No customers found.");
                                        } else {
                                            System.out.println("Customer IDs: " + customerIds.trim());
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    //User selects specific customer
                                    System.out.println("Enter a 5-digit customer ID:");
                                    String customerId = "";
                                    //Verify input what I want 
                                    if (scan.hasNext()) {
                                        customerId = scan.next();
                                        scan.nextLine();
                                        if (customerId.equals("0")) {
                                            managerLoop = false;
                                            break;
                                        }
                                        if (customerId.length() != 5 || !customerId.matches("\\d{5}")) {
                                            System.out.println("Invalid input. Please enter a 5-digit numeric customer ID.");
                                            continue;
                                        }
                                    } else {
                                        System.out.println("Invalid input. Please enter a 5-digit numeric customer ID.");
                                        scan.next();
                                        continue;
                                    }
                                    //Query to get the total balance for the customer
                                    query = "SELECT SUM(balance) FROM account WHERE customer = '" + customerId +"'";
                                    try (ResultSet rs = stmt.executeQuery(query)) {
                                        if (rs.next()) {
                                            System.out.println("Total balance for customer " + customerId + ": " + rs.getInt(1));
                                        } else {
                                            System.out.println("No records found for customer " + customerId + ".");
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    //Query to get the total loans for the customer
                                    query = "SELECT SUM(balance) FROM loan WHERE customer = '" + customerId + "'";
                                    try (ResultSet rs = stmt.executeQuery(query)) {
                                        if (rs.next()) {
                                            System.out.println("Total loans for customer " + customerId + ": " + rs.getInt(1));
                                        } else {
                                            System.out.println("No records found for customer " + customerId + ".");
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                case 4:
                                    //Computer the aggregated information for the bank stuff
                                    System.out.println("Computing transaction frequency and dollar volume:");
                                    //I said I might as well give them all of them why not 
                                    //This is daily breakdown
                                    query = "SELECT COUNT(id) AS transaction_count, SUM(amount) AS total_amount, " +
                                            "TO_CHAR(transaction_date, 'YYYY-MM-DD') AS period " +
                                            "FROM transaction " +
                                            "GROUP BY TO_CHAR(transaction_date, 'YYYY-MM-DD')";
                                    try (ResultSet rs = stmt.executeQuery(query)) {
                                        System.out.println("Daily Transactions:");
                                        while (rs.next()) {
                                            System.out.println("Date: " + rs.getString("period") +
                                                    ", Transactions: " + rs.getInt("transaction_count") +
                                                    ", Total Amount: " + rs.getDouble("total_amount"));
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    //This is monthly breakdown
                                    query = "SELECT COUNT(id) AS transaction_count, SUM(amount) AS total_amount, " +
                                            "TO_CHAR(transaction_date, 'YYYY-MM') AS period " +
                                            "FROM transaction " +
                                            "GROUP BY TO_CHAR(transaction_date, 'YYYY-MM')";
                                    try (ResultSet rs = stmt.executeQuery(query)) {
                                        System.out.println("Monthly Transactions:");
                                        while (rs.next()) {
                                            System.out.println("Month: " + rs.getString("period") +
                                                    ", Transactions: " + rs.getInt("transaction_count") +
                                                    ", Total Amount: " + rs.getDouble("total_amount"));
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    //This is yearly breakdown
                                    query = "SELECT COUNT(id) AS transaction_count, SUM(amount) AS total_amount, " +
                                            "TO_CHAR(transaction_date, 'YYYY') AS period " +
                                            "FROM transaction " +
                                            "GROUP BY TO_CHAR(transaction_date, 'YYYY')";
                                    try (ResultSet rs = stmt.executeQuery(query)) {
                                        System.out.println("Yearly Transactions:");
                                        while (rs.next()) {
                                            System.out.println("Year: " + rs.getString("period") +
                                                    ", Transactions: " + rs.getInt("transaction_count") +
                                                    ", Total Amount: " + rs.getDouble("total_amount"));
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                default:
                                    System.out.println("Invalid input. Please enter a valid option.");
                                    break;
                            }
                        }
                    } 

                /* START OF CUSTOMER INTERFACE  */
                //This is where I started to experiment with prepared statments 
                else if (choice == 2) {
                    //List Customers and make the user select one 
                    boolean validCustomer = true;
                    String customerId = "";
                    while (validCustomer) {
                        String query = "SELECT id, name FROM customer";
                        try (PreparedStatement pstmt = conn.prepareStatement(query);
                             ResultSet rs = pstmt.executeQuery()) {
                            System.out.println("Available Customer IDs:");
                            while (rs.next()) {
                                System.out.print(rs.getString("id") + " ");
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }

                        System.out.println("Select a customer ID from the list above:");
                        customerId = scan.nextLine();
                        //Get the selected customer and check if they are in the database
                        query = "SELECT COUNT(*) FROM customer WHERE id = ?";
                        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                            pstmt.setString(1, customerId);
                            try (ResultSet rs = pstmt.executeQuery()) {
                                if (rs.next() && rs.getInt(1) > 0) {
                                    validCustomer = false;
                                } else {
                                    System.out.println("Invalid customer ID. Please try again.");
                                }
                            }
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                    //Customer interface after they have selected a customer
                    boolean customerLoop = true;
                    while (customerLoop) {
                        System.out.println("Welcome Customer:");
                        System.out.println("[1] Deposit");
                        System.out.println("[2] Withdraw");
                        System.out.println("[3] Repayment on loan or credit card");
                        System.out.println("[4] Take out new loan");
                        System.out.println("[5] Purchase using card");
                        System.out.println("[0] to return to the main menu");

                        //Verify that the choice is correct and one of the options 
                        int customerChoice = 0;
                        if (scan.hasNextInt()) {
                            customerChoice = scan.nextInt();
                            scan.nextLine(); 
                            if (customerChoice == 0) {
                                customerLoop = false;
                                break;
                            } else if (customerChoice < 0 || customerChoice > 5) {
                                System.out.println("Invalid input. Please enter a valid option.");
                                continue;
                            }
                        } else {
                            System.out.println("Invalid input. Please enter a numeric option.");
                            scan.next();
                            continue;
                        }

                        switch (customerChoice) {
                            /* START OF DEPOSIT INTERFACE  */
                            case 1:
                                //List accounts that the user can deposit into for thois specific customer
                                System.out.println("Select account ID for deposit (or type '0' to exit):");
                                String query = "SELECT id, balance FROM account WHERE customer = ?";
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    pstmt.setString(1, customerId);
                                    try (ResultSet rs = pstmt.executeQuery()) {
                                        while (rs.next()) {
                                            System.out.println("Account ID: " + rs.getString("id") + ", Balance: " + rs.getDouble("balance"));
                                        }
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                //See if they want to exit this is the only time I'm commenting this
                                String depositAccountId = scan.nextLine();
                                if (depositAccountId.equals("0")) {
                                    break;
                                }
                                System.out.println("Enter deposit amount (or type '0' to exit):");
                                double depositAmount = 0;
                                if (scan.hasNextDouble()) {
                                    depositAmount = scan.nextDouble();
                                    scan.nextLine(); 
                                    if (depositAmount < 0) {
                                        System.out.println("Invalid input. Deposit amount must be positive.");
                                        continue;
                                    } else if (depositAmount == 0) {
                                        break;
                                    }
                                } else {
                                    System.out.println("Invalid input. Please enter a numeric amount.");
                                    scan.next(); 
                                    continue;
                                }
                                //Update the account balance with the deposit amount
                                query = "UPDATE account SET balance = balance + ? WHERE id = ?";
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    pstmt.setDouble(1, depositAmount);
                                    pstmt.setString(2, depositAccountId);
                                    int rowsAffected = pstmt.executeUpdate();
                                    if (rowsAffected > 0) {
                                        System.out.println("Deposit successful.");
                                    } else {
                                        System.out.println("Deposit failed. Ensure the account ID is correct.");
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                //Insert transaction record if deposit was successful
                                query = "INSERT INTO transaction (id, sender, reciepient, amount, transaction_date) VALUES ('T' || LPAD(transaction_seq.NEXTVAL, 3, '0'), NULL, ?, ?, SYSDATE)";
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    pstmt.setString(1, depositAccountId);
                                    pstmt.setDouble(2, depositAmount);
                                    int rowsAffected = pstmt.executeUpdate();
                                    if (rowsAffected > 0) {
                                        System.out.println("Transaction record created successfully.");
                                    } else {
                                        System.out.println("Failed to create transaction record.");
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                break;
                                
                            /* START OF WITHDRAW INTERFACE  */
                            case 2:
                                //List accounts that the user can withdraw from for this specific customer
                                System.out.println("Select account ID for withdrawal (or type '0' to exit):");
                                query = "SELECT id, balance FROM account WHERE customer = ?";
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    pstmt.setString(1, customerId);
                                    try (ResultSet rs = pstmt.executeQuery()) {
                                        while (rs.next()) {
                                            System.out.println("Account ID: " + rs.getString("id") + ", Balance: " + rs.getDouble("balance"));
                                        }
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    continue;
                                }
                                String withdrawAccountId = scan.nextLine();
                                if (withdrawAccountId.equals("0")) {
                                    break;
                                }
                                //Same deal with getting and verifying 
                                System.out.println("Enter withdrawal amount (or type '0' to exit):");
                                double withdrawAmount = 0;
                                if (scan.hasNextDouble()) {
                                    withdrawAmount = scan.nextDouble();
                                    scan.nextLine(); 
                                    if (withdrawAmount < 0) {
                                        System.out.println("Invalid input. Withdrawal amount must be positive.");
                                        continue;
                                    } else if (withdrawAmount == 0) {
                                        break;
                                    }
                                } else {
                                    System.out.println("Invalid input. Please enter a numeric amount.");
                                    scan.next(); // Clear invalid input
                                    continue;
                                }

                                //Check account balance before withdrawal
                                query = "SELECT balance FROM account WHERE id = ?";
                                double currentBalance = 0;
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    pstmt.setString(1, withdrawAccountId);
                                    try (ResultSet rs = pstmt.executeQuery()) {
                                        if (rs.next()) {
                                            currentBalance = rs.getDouble("balance");
                                        }
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    continue;
                                }

                                //Check if the account is a checking account
                                boolean isCheckingAccount = false;
                                query = "SELECT COUNT(*) FROM checking_account WHERE id = ?";
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    pstmt.setString(1, withdrawAccountId);
                                    try (ResultSet rs = pstmt.executeQuery()) {
                                        if (rs.next() && rs.getInt(1) > 0) {
                                            isCheckingAccount = true;
                                        }
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    continue;
                                }

                                //Check if the account is a savings account
                                boolean isSavingsAccount = false;
                                query = "SELECT COUNT(*) FROM savings_account WHERE id = ?";
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    pstmt.setString(1, withdrawAccountId);
                                    try (ResultSet rs = pstmt.executeQuery()) {
                                        if (rs.next() && rs.getInt(1) > 0) {
                                            isSavingsAccount = true;
                                        }
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    continue;
                                }

                                //Check if the account is an investment account
                                boolean isInvestmentAccount = false;
                                query = "SELECT COUNT(*) FROM investment_account WHERE id = ?";
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    pstmt.setString(1, withdrawAccountId);
                                    try (ResultSet rs = pstmt.executeQuery()) {
                                        if (rs.next() && rs.getInt(1) > 0) {
                                            isInvestmentAccount = true;
                                        }
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    continue;
                                }
                                //Check if the account is a investment account or undefined 
                                if (!isCheckingAccount && !isSavingsAccount && isInvestmentAccount) {
                                    System.out.println("Withdrawal failed. Cannot withdraw money from investment account.");
                                    continue;
                                } else if (!isCheckingAccount && !isSavingsAccount && !isInvestmentAccount) {
                                    System.out.println("Withdrawal failed. Undefined account type.");
                                    continue;
                                }

                                // Check if the withdrawal will cause the checking account to go negative
                                if (isCheckingAccount && currentBalance - withdrawAmount < 0) {
                                    System.out.println("Withdrawal failed. Checking account cannot go negative.");
                                    continue;
                                }

                                //Check if the withdrawal will cause the savings account to go below the minimum balance
                                if (isSavingsAccount) {
                                    double minBalance = 0;
                                    query = "SELECT min_balance FROM savings_account WHERE id = ?";
                                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                        pstmt.setString(1, withdrawAccountId);
                                        try (ResultSet rs = pstmt.executeQuery()) {
                                            if (rs.next()) {
                                                minBalance = rs.getDouble("min_balance");
                                            }
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                        continue;
                                    }
                                    //Add a fee if the withdrawal will cause the savings account to go below the minimum balance
                                    if (currentBalance - withdrawAmount < minBalance) {
                                        System.out.println("Savings account balance below minimum. Charging additional $50 fee.");
                                        withdrawAmount += 50;
                                    }
                                }
                                //Here all transactions should be good to update affected accounts 
                                query = "UPDATE account SET balance = balance - ? WHERE id = ?";
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    pstmt.setDouble(1, withdrawAmount);
                                    pstmt.setString(2, withdrawAccountId);
                                    int rowsAffected = pstmt.executeUpdate();
                                    if (rowsAffected > 0) {
                                        System.out.println("Withdrawal successful.");
                                    } else {
                                        System.out.println("Withdrawal failed. Ensure the account ID is correct.");
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    continue;
                                }
                                //Insert transaction record if withdrawal was successful
                                query = "INSERT INTO transaction (id, sender, reciepient, amount, transaction_date) VALUES ('T' || LPAD(transaction_seq.NEXTVAL, 3, '0'), ?, NULL, ?, SYSDATE)";
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    pstmt.setString(1, withdrawAccountId);
                                    pstmt.setDouble(2, withdrawAmount);
                                    int rowsAffected = pstmt.executeUpdate();
                                    if (rowsAffected > 0) {
                                        System.out.println("Transaction record created successfully.");
                                    } else {
                                        System.out.println("Failed to create transaction record.");
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                break;
                            /* START OF REPAYMENT INTERFACE  */
                            case 3:
                                //Payment on loan or credit card
                                while (true) {
                                    System.out.println("Loans:");
                                    query = "SELECT id, balance, payment_due FROM loan WHERE customer = ?";
                                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                        pstmt.setString(1, customerId);
                                        try (ResultSet rs = pstmt.executeQuery()) {
                                            while (rs.next()) {
                                                System.out.println("Loan ID: " + rs.getString("id") + ", Balance: " + rs.getDouble("balance") + ", Due Date: " + rs.getString("payment_due"));
                                            }
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    //List all the credit cards for the user
                                    System.out.println("Credit Cards:");
                                    query = "SELECT credit.id AS id, credit.balance_due AS balance, credit.min_payment AS min_payment " +
                                            "FROM credit JOIN card ON card.id = credit.id WHERE card.customer = ?";
                                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                        pstmt.setString(1, customerId);
                                        try (ResultSet rs = pstmt.executeQuery()) {
                                            while (rs.next()) {
                                                System.out.println("Credit Card ID: " + rs.getString("id") + ", Balance Due: " + rs.getDouble("balance") + ", Min Payment: " + rs.getDouble("min_payment"));
                                            }
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                    //User selects what they want to repay
                                    System.out.println("Would you like to repay a [1] Loan or [2] Credit Card? (or type '0' to exit):");
                                    int repaymentChoice = 0;
                                    if (scan.hasNextInt()) {
                                        repaymentChoice = scan.nextInt();
                                        scan.nextLine(); // Clear scanner
                                        if (repaymentChoice == 0) {
                                            break;
                                        } else if (repaymentChoice < 1 || repaymentChoice > 2) {
                                            System.out.println("Invalid input. Please enter a valid option.");
                                            continue;
                                        }
                                    } else {
                                        System.out.println("Invalid input. Please enter a numeric option.");
                                        scan.next(); // Clear invalid input
                                        continue;
                                    }
                                    //Prompting based Loan or Credit repayment so I can query the correct table
                                    String paymentId = "";
                                    if (repaymentChoice == 1) {
                                        System.out.println("Enter Loan ID to repay (or type '0' to exit):");
                                        paymentId = scan.nextLine();
                                        if (paymentId.equals("0")) {
                                            break;
                                        }
                                    
                                    } else if (repaymentChoice == 2) {
                                        System.out.println("Credit Cards:");
                                        query = "SELECT credit.id AS id, credit.balance_due AS balance, credit.min_payment AS min_payment " +
                                                "FROM credit JOIN card ON card.id = credit.id WHERE card.customer = ?";
                                        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                            pstmt.setString(1, customerId);
                                            try (ResultSet rs = pstmt.executeQuery()) {
                                                while (rs.next()) {
                                                    System.out.println("Credit Card ID: " + rs.getString("id") + ", Balance Due: " + rs.getDouble("balance") + ", Min Payment: " + rs.getDouble("min_payment"));
                                                }
                                            }
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("Enter Credit Card ID to repay (or type '0' to exit):");
                                        paymentId = scan.nextLine();
                                        if (paymentId.equals("0")) {
                                            break;
                                        }
                                    }
                                    //Verify entered payment amount is valid
                                    System.out.println("Enter payment amount (or type '0' to exit):");
                                    double paymentAmount = 0;
                                    if (scan.hasNextDouble()) {
                                        paymentAmount = scan.nextDouble();
                                        scan.nextLine(); 
                                        if (paymentAmount <= 0) {
                                            System.out.println("Invalid input. Payment amount must be positive.");
                                            continue;
                                        }
                                    } else {
                                        System.out.println("Invalid input. Please enter a numeric amount.");
                                        scan.next(); 
                                        continue;
                                    }

                                    //Check if the payment amount is greater than the minimum payment for credit card and less than the balance due
                                    if (repaymentChoice == 2) {
                                        double minPayment = 0;
                                        double balanceDue = 0;
                                        query = "SELECT min_payment, balance_due FROM credit WHERE id = ?";
                                        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                            pstmt.setString(1, paymentId);
                                            try (ResultSet rs = pstmt.executeQuery()) {
                                                if (rs.next()) {
                                                    minPayment = rs.getDouble("min_payment");
                                                    balanceDue = rs.getDouble("balance_due");
                                                }
                                            }
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                            continue;
                                        }

                                        if (paymentAmount < minPayment) {
                                            System.out.println("Payment amount must be greater than or equal to the minimum payment of " + minPayment);
                                            continue;
                                        } else if (paymentAmount > balanceDue) {
                                            System.out.println("Payment amount exceeds the balance due. Please enter a valid amount.");
                                            break;
                                        }
                                    //Verifying for the loans now 
                                    } else {
                                        query = "SELECT balance FROM loan WHERE id = ?";
                                        double loanBalance = 0;
                                        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                            pstmt.setString(1, paymentId);
                                            try (ResultSet rs = pstmt.executeQuery()) {
                                                if (rs.next()) {
                                                    loanBalance = rs.getDouble("balance");
                                                }
                                            }
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                            continue;
                                        }
                                        //same deal as above
                                        if (paymentAmount > loanBalance) {
                                            System.out.println("Payment amount exceeds the loan balance. Please enter a valid amount.");
                                            break;
                                        }
                                    }
                                    //Select account to pay from
                                    System.out.println("Select account ID for payment (or type '0' to exit):");
                                    query = "SELECT id, balance FROM account WHERE customer = ?";
                                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                        pstmt.setString(1, customerId);
                                        try (ResultSet rs = pstmt.executeQuery()) {
                                            while (rs.next()) {
                                                System.out.println("Account ID: " + rs.getString("id") + ", Balance: " + rs.getDouble("balance"));
                                            }
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }

                                    String paymentAccountId = scan.nextLine();
                                    if (paymentAccountId.equals("0")) {
                                        break;
                                    }

                                    if (repaymentChoice == 1) {
                                        //Repayment logic for loan
                                        query = "UPDATE loan SET balance = balance - ? WHERE id = ?";
                                        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                            pstmt.setDouble(1, paymentAmount);
                                            pstmt.setString(2, paymentId);
                                            int rowsAffected = pstmt.executeUpdate();
                                            if (rowsAffected > 0) {
                                                System.out.println("Loan payment successful.");
                                            } else {
                                                System.out.println("Loan payment failed. Ensure the loan ID is correct.");
                                            }
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                    } else {
                                        //Repayment logic for credit card
                                        query = "UPDATE credit SET balance_due = balance_due - ? WHERE id = ?";
                                        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                            pstmt.setDouble(1, paymentAmount);
                                            pstmt.setString(2, paymentId);
                                            int rowsAffected = pstmt.executeUpdate();
                                            if (rowsAffected > 0) {
                                                System.out.println("Credit card payment successful.");
                                            } else {
                                                System.out.println("Credit card payment failed. Ensure the credit card ID is correct.");
                                            }
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    //Insert transaction record for repayment
                                    query = "INSERT INTO transaction (id, sender, reciepient, amount, transaction_date) VALUES ('T' || LPAD(transaction_seq.NEXTVAL, 3, '0'), ?, ?, ?, SYSDATE)";
                                    String transactionId = null;
                                    try (PreparedStatement pstmt = conn.prepareStatement(query, new String[] {"id"})) {
                                        pstmt.setString(1, paymentAccountId);
                                        pstmt.setString(2, paymentId);
                                        pstmt.setDouble(3, paymentAmount);
                                        int rowsAffected = pstmt.executeUpdate();
                                        if (rowsAffected > 0) {
                                            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                                                if (generatedKeys.next()) {
                                                    transactionId = generatedKeys.getString(1);
                                                    System.out.println("Transaction record created successfully with ID: " + transactionId);
                                                } else {
                                                    System.out.println("Failed to retrieve transaction ID.");
                                                }
                                            }
                                        } else {
                                            System.out.println("Failed to create transaction record.");
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }

                                    //Insert repayment record
                                    double minPayment = 0;
                                    if (repaymentChoice == 2) {
                                        query = "SELECT min_payment FROM credit WHERE id = ?";
                                        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                            pstmt.setString(1, paymentId);
                                            try (ResultSet rs = pstmt.executeQuery()) {
                                                if (rs.next()) {
                                                    minPayment = rs.getDouble("min_payment");
                                                }
                                            }
                                        } catch (SQLException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    //Inserting the repayment record
                                    query = "INSERT INTO repayment (id, min_repayment) VALUES (?, ?)";
                                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                        pstmt.setString(1, transactionId);
                                        pstmt.setDouble(2, minPayment);
                                        int rowsAffected = pstmt.executeUpdate();
                                        if (rowsAffected > 0) {
                                            System.out.println("Repayment record created successfully.");
                                        } else {
                                            System.out.println("Failed to create repayment record.");
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                    }
                                } break;
                            /* START OF TAKE OUT NEW LOAN INTERFACE  */
                            case 4:
                                //Take out new loan
                                System.out.println("Enter loan amount (or type '0' to exit):");
                                double loanAmount = scan.nextDouble();
                                scan.nextLine();
                                if (loanAmount == 0) {
                                    break;
                                }
                                if (loanAmount <= 0) {
                                    System.out.println("Invalid input. Loan amount must be positive.");
                                    continue;
                                }
                                //Insert new loan 
                                query = "INSERT INTO loan (id, customer, balance, payment_due) VALUES ('L' || LPAD(loan_seq.NEXTVAL, 3, '0'), ?, ?, ADD_MONTHS(SYSDATE, 1))";
                                try (PreparedStatement pstmt = conn.prepareStatement(query, new String[] {"id"})) {
                                    pstmt.setString(1, customerId);
                                    pstmt.setDouble(2, loanAmount);
                                    int rowsAffected = pstmt.executeUpdate();
                                    //Had to look this up to get the generated key
                                    if (rowsAffected > 0) {
                                        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                                            if (generatedKeys.next()) {
                                                String newLoanId = generatedKeys.getString(1);
                                                System.out.println("New loan taken out successfully with ID: " + newLoanId);
                                            } else {
                                                System.out.println("Failed to retrieve new loan ID.");
                                            }
                                        }
                                    } else {
                                        System.out.println("Failed to take out new loan.");
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                break;

                            /* START OF PURCHASE USING CARD INTERFACE  */
                            case 5:
                                //Purchase using card
                                System.out.println("Enter card ID for purchase (or type '0' to exit):");
                                query = "SELECT id FROM card WHERE customer = ?";
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    pstmt.setString(1, customerId);
                                    try (ResultSet rs = pstmt.executeQuery()) {
                                        System.out.println("Available Card IDs:");
                                        while (rs.next()) {
                                            System.out.print(rs.getString("id") + " ");
                                        }
                                        System.out.println();
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                String purchaseCardId = scan.nextLine();
                                if (purchaseCardId.equals("0")) {
                                    break;
                                        }
                                System.out.println("Enter purchase amount (or type '0' to exit):");
                                double purchaseAmount = 0;
                                if (scan.hasNextDouble()) {
                                    purchaseAmount = scan.nextDouble();
                                    scan.nextLine(); 
                                    if (purchaseAmount <= 0) {
                                        System.out.println("Invalid input. Purchase amount must be positive.");
                                        continue;
                                    }
                                } else {
                                    System.out.println("Invalid input. Please enter a numeric amount.");
                                    scan.next(); 
                                    continue;
                                }

                                //Check if the card is a debit or credit card
                                boolean isDebitCard = false;
                                boolean isCreditCard = false;
                                query = "SELECT COUNT(*) FROM debit WHERE id = ?";
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    pstmt.setString(1, purchaseCardId);
                                    try (ResultSet rs = pstmt.executeQuery()) {
                                        if (rs.next() && rs.getInt(1) > 0) {
                                            isDebitCard = true;
                                        }
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    continue;
                                }
                                //Check to see if it is a credit card if it is not a debit card
                                if (!isDebitCard) {
                                    query = "SELECT COUNT(*) FROM credit WHERE id = ?";
                                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                        pstmt.setString(1, purchaseCardId);
                                        try (ResultSet rs = pstmt.executeQuery()) {
                                            if (rs.next() && rs.getInt(1) > 0) {
                                                isCreditCard = true;
                                            }
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                        continue;
                                    }
                                }

                                if (isDebitCard) {
                                    //Check if the associated checking account has sufficient balance
                                    query = "SELECT id, balance FROM account WHERE id = (SELECT account FROM card WHERE id = ?)";
                                    double accountBalance = 0;
                                    String associatedAccountId = "";
                                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                        pstmt.setString(1, purchaseCardId);
                                        try (ResultSet rs = pstmt.executeQuery()) {
                                            if (rs.next()) {
                                                accountBalance = rs.getDouble("balance");
                                                associatedAccountId = rs.getString("id");
                                            }
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                        continue;
                                    }

                                    if (accountBalance < purchaseAmount) {
                                        System.out.println("Purchase declined. Insufficient balance in the associated checking account.");
                                        continue;
                                    }

                                    //Update the associated account balance
                                    query = "UPDATE account SET balance = balance - ? WHERE id = ?";
                                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                        pstmt.setDouble(1, purchaseAmount);
                                        pstmt.setString(2, associatedAccountId);
                                        int rowsAffected = pstmt.executeUpdate();
                                        if (rowsAffected > 0) {
                                            System.out.println("Purchase successful.");
                                        } else {
                                            System.out.println("Purchase failed. Ensure the account ID is correct.");
                                            continue;
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                        continue;
                                    }

                                } else if (isCreditCard) {
                                    //Check if the outstanding balance after the transaction does not exceed the credit limit
                                    query = "SELECT balance_due, credit_limit FROM credit WHERE id = ?";
                                    double balanceDue = 0;
                                    double creditLimit = 0;
                                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                        pstmt.setString(1, purchaseCardId);
                                        try (ResultSet rs = pstmt.executeQuery()) {
                                            if (rs.next()) {
                                                balanceDue = rs.getDouble("balance_due");
                                                creditLimit = rs.getDouble("credit_limit");
                                            }
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                        continue;
                                    }

                                    if (balanceDue + purchaseAmount > creditLimit) {
                                        System.out.println("Purchase declined. Outstanding balance exceeds the credit limit.");
                                        continue;
                                    }

                                    //Update the credit balance due
                                    query = "UPDATE credit SET balance_due = balance_due + ? WHERE id = ?";
                                    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                        pstmt.setDouble(1, purchaseAmount);
                                        pstmt.setString(2, purchaseCardId);
                                        int rowsAffected = pstmt.executeUpdate();
                                        if (rowsAffected > 0) {
                                            System.out.println("Purchase successful.");
                                        } else {
                                            System.out.println("Purchase failed. Ensure the card ID is correct.");
                                            continue;
                                        }
                                    } catch (SQLException e) {
                                        e.printStackTrace();
                                        continue;
                                    }

                                } else {
                                    System.out.println("Invalid card ID. Please try again.");
                                    continue;
                                }

                                //Insert transaction record for purchase
                                query = "INSERT INTO transaction (id, sender, reciepient, amount, transaction_date) VALUES ('T' || LPAD(transaction_seq.NEXTVAL, 3, '0'), ?, NULL, ?, SYSDATE)";
                                String transactionId = null;
                                try (PreparedStatement pstmt = conn.prepareStatement(query, new String[] {"id"})) {
                                    pstmt.setString(1, purchaseCardId);
                                    pstmt.setDouble(2, purchaseAmount);
                                    int rowsAffected = pstmt.executeUpdate();
                                    if (rowsAffected > 0) {
                                        try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                                            if (generatedKeys.next()) {
                                                transactionId = generatedKeys.getString(1);
                                                System.out.println("Transaction record created successfully with ID: " + transactionId);
                                            } else {
                                                System.out.println("Failed to retrieve transaction ID.");
                                            }
                                        }
                                    } else {
                                        System.out.println("Failed to create transaction record.");
                                        continue;
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                    continue;
                                }

                                //Insert transfer record
                                query = "INSERT INTO transfer (id, message) VALUES (?, ?)";
                                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                                    //Didn't know what to put for message so I just put purchase at vendor
                                    pstmt.setString(1, transactionId);
                                    pstmt.setString(2, "Purchase at vendor");
                                    int rowsAffected = pstmt.executeUpdate();
                                    if (rowsAffected > 0) {
                                        System.out.println("Transfer record created successfully.");
                                    } else {
                                        System.out.println("Failed to create transfer record.");
                                    }
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                                }
                            }
                        }
                        else{
                            System.out.println("Invalid input. Please enter a valid role.");
                            continue;
                        }
                }//While Loop for interface   
            }//Try End Statemtn for Connection
            catch (SQLException sqle) 
            { System.out.println("SQLException : " + sqle);}
        scan.close();
    }
}