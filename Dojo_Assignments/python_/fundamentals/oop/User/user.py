class User:
    def __init__(self, first_name, last_name, email,balance):
        self.first_name = first_name
        self.last_name = last_name
        self.email = email 
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount

    def make_withdrawal(self, amount):
        self.balance -= amount

    def display_user_balance(self):
        print(self.balance)
    
    def transfer_money(self, other_user, amount):
        self.balance -= amount
        other_user.balance += amount

customer1 = User('Ian', 'Rogers', 'danielirogers3@gmail.com', 50000)
customer2 = User('Pable', 'Padilla', 'pablop@gmail.com', 300000)
customer3 = User('Skye', 'Grossman', 'skyegross@gmail.com', 1000000)

customer1.deposit(200)
customer1.deposit(400)
customer1.deposit(245)
customer1.make_withdrawal(42)
customer1.display_user_balance()

customer2.deposit(10)
customer2.deposit(24)
customer2.make_withdrawal(54)
customer2.make_withdrawal(20000)
customer2.display_user_balance()

customer3.deposit(10000)
customer3.make_withdrawal(123)
customer3.make_withdrawal(567)
customer3.make_withdrawal(789)
customer3.display_user_balance()

customer1.display_user_balance()
customer3.display_user_balance()
customer3.transfer_money(customer1, 200000)
customer1.display_user_balance()
customer3.display_user_balance()

