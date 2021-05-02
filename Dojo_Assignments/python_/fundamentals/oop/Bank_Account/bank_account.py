class BankAccount:
    # don't forget to add some default values for these parameters!
    all_accounts = []
    def __init__(self, int_rate = 0.1, balance = 0): 
        # your code here! (remember, instance attributes go her
        self.int_rate = int_rate
        self.balance = balance
        BankAccount.all_accounts.append(self)
        # don't worry about user info here; we'll involve the class soon
    def deposit(self, amount):
        self.balance += amount
        return self
    def withdraw(self, amount):
        # your code here
        if BankAccount.can_withdrawal(self.balance, amount):
            self.balance -= amount
        else:
            print("Insufficient Funds: Charging a $5 fee")
            self.balance -= (amount + 5)
        return self
    def display_account_info(self):
        # your code here
        print(f"Balance: ${self.balance}")
        return self
    def yield_interest(self):
        # your code here
        self.balance += (self.balance * self.int_rate)
        return self
    @staticmethod
    def can_withdrawal(balance, amount):
        if (balance - amount) < 0:
            return False
        else: 
            return True
    @classmethod
    def getAllInfo(cls):
        for x in cls.all_accounts:
            x.display_account_info()


customer1 = BankAccount(0.01, 10000)
customer2 = BankAccount(0.02, 1000)

customer1.deposit(123).deposit(234).deposit(456).withdraw(123).yield_interest().display_account_info()
customer2.deposit(123).deposit(234).withdraw(234).withdraw(123).withdraw(123).withdraw(123).yield_interest().display_account_info()

BankAccount.getAllInfo()
