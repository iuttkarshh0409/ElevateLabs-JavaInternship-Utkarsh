# 🏦 Bank Management System

A command-line based **Bank Management System** built in **Java** using **Object-Oriented Programming principles**. This application simulates banking operations, allowing users to manage a savings account with features like deposits, withdrawals, balance checks, and transaction history tracking. Developed as part of the **Elevate Labs Java Developer Internship** to practice OOP concepts and input validation.

---

## 💻 Features

- ✅ **Account Creation**: Initialize a savings account with account holder name, initial balance (minimum INR 5000), and IFSC code.
- ✅ **Deposit**: Add funds to the account with validation for positive amounts.
- ✅ **Withdraw**: Withdraw funds, ensuring sufficient balance and maintaining a minimum balance of INR 5000 for savings accounts.
- ✅ **View Balance**: Check the current account balance.
- ✅ **Account Details**: Display account holder name, balance, IFSC code, and account type.
- ✅ **Transaction History**: Track and display all transactions (deposits, withdrawals, and balance checks).
- ✅ **Interactive Menu**: Menu-driven interface with input validation and continue/exit options.
- ✅ **Graceful Exit**: Terminates with a thank-you message.

---

## 🛠️ Tools & Technologies

- **Language**: Java 17
- **IDE**: Visual Studio Code
- **Interface**: Terminal (Command Line Interface)
- **Key Libraries**: `java.util.Scanner`, `java.util.ArrayList`
- **Exception Handling**: `NumberFormatException` for invalid numeric inputs

---

## 📂 Project Structure

```
BankManagementSystem
├── BankApp.java  # Main Java application with Account and SavingsAccount classes
└── README.md     # Project documentation
```

### 📌 Classes
- **Account**: Base class managing account details, balance, and transaction history.
- **SavingsAccount**: Extends `Account`, enforcing a minimum balance of INR 5000 for withdrawals.
- **BankApp**: Main class with the console interface and application logic.

---

## 🔍 How It Works

- **Account Creation**: Prompts for account holder name, initial balance (≥ INR 5000), and IFSC code with input validation.
- **Deposit**: Adds a positive amount to the balance and logs the transaction.
- **Withdraw**: Allows withdrawals if the resulting balance meets the minimum requirement (INR 5000) and logs the transaction.
- **View Balance**: Displays the current balance and logs the check.
- **Account Details**: Shows account holder name, balance, IFSC code, and account type.
- **Transaction History**: Lists all transactions (deposits, withdrawals, balance checks).
- **Menu Interaction**: Provides a numbered menu (1–6) with robust input validation and a continue prompt (Y/N).

---

## ✅ Key Features & Improvements

| Feature/Improvement            | Description                                              |
|-------------------------------|----------------------------------------------------------|
| Input Validation              | Handles empty inputs, non-numeric inputs, and invalid amounts |
| Minimum Balance               | Enforces INR 5000 minimum for savings account withdrawals |
| Transaction History           | Tracks all deposits, withdrawals, and balance checks      |
| Error Messages                | User-friendly feedback for all invalid actions           |
| Continue Prompt               | Allows users to continue or exit after each action       |
| OOP Design                    | Uses inheritance (`SavingsAccount` extends `Account`)     |
| Robust Menu                   | Handles invalid menu options (outside 1–6) gracefully     |

---

## 🚀 Sample Execution

```
----- Welcome to Bank Management System -----

Please submit the details to avail the services of account instantly...

Enter Account Holder Name: John Doe
Enter deposit amount (minimum INR 5000): 10000
Enter Branch IFSC Code: SBIN0001234

Thank you for providing the Details!

-- Application Menu --
1. Deposit
2. Withdraw
3. View Balance
4. View Account Details
5. View Transaction History
6. Exit

Enter your choice: 1
Enter amount to deposit: 5000
Deposit of INR 5000 is successful!

Do you want to continue? (y/n): y
```

---

## 📎 Concepts Practiced

- **Object-Oriented Programming**: Inheritance (`SavingsAccount` extends `Account`), encapsulation, and polymorphism.
- **Input Handling**: `Scanner` for user input with validation for strings and numbers.
- **Data Structures**: `ArrayList` for storing transaction history.
- **Exception Handling**: `NumberFormatException` for invalid numeric inputs.
- **Defensive Programming**: Validation for empty inputs, negative amounts, and insufficient balance.

---

## 🔐 Edge Case Handling

| Case                              | Behavior                                              |
|-----------------------------------|-------------------------------------------------------|
| Empty account holder name         | Rejected with prompt to retry                         |
| Initial balance < INR 5000        | Rejected with error message                           |
| Empty IFSC code                   | Rejected with prompt to retry                         |
| Negative or zero deposit/withdrawal| Rejected with error message                           |
| Withdrawal below minimum balance   | Rejected with minimum balance warning                 |
| Non-numeric input for amounts      | Handled with `NumberFormatException`                  |
| Invalid menu option (not 1–6)     | Rejected with error message                           |
| Empty menu input                  | Rejected with prompt to enter a valid number          |

---

## 🙌 Author

**Utkarsh Dubey**  
*Java Developer Intern @ Elevate Labs*  
📍 Devi Ahilya Vishwavidyalaya, Indore  
💼 GitHub: [iuttkarshh0409](https://github.com/iuttkarshh0409)  
📧 Email: utkarshdubey0409@gmail.com

---

## 📝 License

This project is open-source and free to use for educational and personal projects.