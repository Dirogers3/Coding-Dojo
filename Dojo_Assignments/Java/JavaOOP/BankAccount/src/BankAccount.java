import java.util.*;
public class BankAccount {
	private Integer accountNumber;
	private Double checkingBalance = 0.0;
	private Double savingsBalance = 0.0; 
	private static Integer numberOfAccounts = 0;
	private static Double totalMoney = 0.0;
	
	Random r = new Random();
	private Integer RandomNumberGen() {
		int x = r.nextInt(1000000000);
		return x;
	}
	
	public void BankAccount() {
		 this.accountNumber = RandomNumberGen();
		 numberOfAccounts++;
	}
	
	public void getChecking() {
		System.out.println(this.checkingBalance);
	}
	
	public void getSavings() {
		System.out.println(this.savingsBalance);
	}
	
	public void getBalance() {
		double total = this.checkingBalance + this.savingsBalance;
		System.out.println("There is: $" + total + " in the account");
	}
	
	public void deposit(Double x, Double y) {
		this.checkingBalance =+ x;
		this.savingsBalance =+ y;
		double total = x+y;
		System.out.println("Total deposit amount: " + total);
	}
	public void withdrawal(double money) {
		double total = this.checkingBalance + this.savingsBalance;
		if(money < total) {
			if(money < this.checkingBalance) {
				this.checkingBalance -= money;
			} if (money < this.savingsBalance) {
				this.savingsBalance -= money;
			}
			else {
				System.out.println("Please make sure to move money into the same account for withdrawal!");
			}
		} else {
			System.out.println("Not enough funds!");
		}
	}
}
