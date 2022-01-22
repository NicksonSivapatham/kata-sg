# kata-sg
***
Simulation of a simple bank account capable of :
- Deposit
- Withdraw
- View history

### Model
Amount: Is a positive value use for operation (A negative amount will throw InvalidAmountException).

Balance: Indicate the amount of money available. We can add or substract an amount from this balance.
It has a maximalOverdraft and thus can throw InsufficientFunds if the withdraw leads to an overdraft.

Transaction: Store information of transaction at date (accountId, Deposit/withdraw, date, amount, balance)

### Interface
BankAccountService: Exposes the 3 actions deposit, withdraw and view history. It can be used to connect to different client. For example I implement ATM. But we can imagine having a different implementation for phoneApp...

TransactionRepository: Exposes actions to retrieve transaction information. In this example I used the interface to connect java class which stored the data. But we can use the interface to implement data recovery from database...