# Bank Management System 🏧

## Concepts Used ✅

- Encapsulation
- Abstraction
- Inheritance
- Polymorphism
- Getter and Setter
- Abstract Class
- Interface

## Classes and Interfaces 💡

- BankAccount `Abstract Class`
  - Attributes: `accountNumber`, `balance`, `ownerName`
  - Abstract methods: `deposit()`, `withdraw()`

- SavingsAccount `Child of BankAccount`
  - Attributes: `interestRate`
  - Methods: Implements `deposit()` and `withdraw()`

- CheckingAccount `Child of BankAccount`
  - Methods: Implements `deposit()` and `withdraw()`

- Bank `Interface`
  - Methods: `addAccount()`, `removeAccount()`, `getAccountDetails()`
