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
class User:
    def __init__(self, first_name, last_name, email, num_accounts=1):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email 
        self.account = []
        if num_accounts > 1:
            for i in range(num_accounts):
                self.account.append(BankAccount())
            else:
                self.account.append(BankAccount())

    def userdeposit(self, amount, key=0):
        self.account[key].deposit(amount)
        return self
    def user_make_withdrawal(self, amount, key=0):
        self.account[key].withdrawal(amount)
        return self
    def user_display_balance(self, key = 0):
        print(f"account#: {key} User: {self.name}, Balance: #{self.account[key].balance}")
        return self
    def user_transfer_money(self, other_user, amount, key=0):
        self.account[key].balance -= amount
        other_user.account[key].balance += amount
        print(f"User: {self.first_name}, Balance: ${self.account[key].balance}")
        print(f"User: {other_user.first_name}, Balance: ${other_user.account[key].balance}")


customer1 = User('Ian', 'Rogers', 'danielirogers3@gmail.com',2)
customer2 = User('Pablo', 'Padilla', 'pablop@gmail.com',2)
customer3 = User('Skye', 'Grossman', 'skyegross@gmail.com',2)

customer1.user_transfer_money(customer2,100)