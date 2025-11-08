### 🏦 Vinit Gupta Banking Management App

A simple, console-based banking management system developed in Java. This application demonstrates fundamental **Object-Oriented Programming (OOP)** concepts, including **Abstraction** and **Inheritance**, to manage different types of bank accounts.

-----

### ✨ Features

| Feature | Description |
| :--- | :--- |
| **Account Creation** | Create a new **Savings Account** or a **Current Account**. |
| **Unique Account Numbers** | Automatically generates a 6-digit unique account number. |
| **Transactions** | **Deposit** or **Withdraw** money (with a balance check). |
| **Account Management** | **Check Balance** and **Calculate Interest**. |
| **Interest Calculation** | Adds interest to Savings Accounts (**3% rate**) but none to Current Accounts. |
| **System Tracking** | Display the total number of accounts created. |

-----

### 🛠️ Technology Stack

  * **Language:** Java
  * **Environment:** Terminal/Console Application

-----

### 👨‍💻 OOP Design Overview

The application is structured using a simple class hierarchy:

| Class Name | Type | Description |
| :--- | :--- | :--- |
| `BankAccount` | **Abstract Class** | The base class with common methods like `deposit()`, `withdraw()`, `checkBalance()`, and the abstract method `calculateInterest()`. |
| `SavingsAccount` | **Concrete Class** | Extends `BankAccount`. Implements `calculateInterest()` to apply a 3% interest rate. |
| `CurrentAccount` | **Concrete Class** | Extends `BankAccount`. Implements `calculateInterest()` with no interest added. |
| `Bank` | Utility Class | Provides static methods for generating unique account numbers and tracking the total account count. |
| `MainApp` | Main Class | Contains the `main` method and the application loop. |

-----

### 🚀 How to Run

To compile and run this application, you need to have the **Java Development Kit (JDK)** installed on your system.

1.  **Save the file:** Save the provided code as `MainApp.java`.
2.  **Compile:** Open your terminal or command prompt, navigate to the directory where you saved the file, and compile it:
    ```bash
    javac MainApp.java
    ```
3.  **Run:** Execute the compiled class file:
    ```bash
    java MainApp
    ```

The application menu will then appear, allowing you to interact with the banking system.
