public class BankPatron {

	private String firstName;
	private String lastName;
	private double cashOnHand;
	private double salary;
	public BankAccount account1;
	public BankAccount account2;

	public BankPatron () {
		firstName = "";
		lastName = "";
		cashOnHand = 0;
		salary = 0;
	
		account1 = new BankAccount();
		account2 = new BankAccount();
	}

	public BankPatron (String fName, String lName, double sal, double cash) {
		firstName = fName;
		lastName = lName;
		salary = sal;
		cashOnHand = cash;
	}

	public String getPatronName() {
		return firstName + " " + lastName;
	}

	public double getSalary() {
		return salary;
	}

	public double getCashOnHand() {
		return cashOnHand;
	}

	public void issuePaycheck () {
		cashOnHand += salary/26;
	}

	public BankAccount getAccount(int account) {
		if(account == 1 && account1 != null)  {
			//System.out.println("Account 1");
			return account1;
		} else if (account == 2 && account2 != null) {
			//System.out.println("Account 2");
			return account2;
		} else {
			//System.out.println("Account " + account + "doesn't exist.");
			return null;
		}
	}

	public boolean makeDeposit(int account, double amount) {
		boolean success =  true;

		if(amount <= cashOnHand) {
			if(account == 1 && account1 != null) {
				cashOnHand -= amount;
				//System.out.println("CIH " + cashOnHand);
				account1.deposit(amount);
				success = true;
			} else if (account == 2 && account2 != null) {
				cashOnHand -= amount;
				//System.out.println("CIH " + cashOnHand);
				account2.deposit(amount);
				success = true;
			} else {
				//System.out.println("Patron has enough money (" + amount + ") but account " + account + " doesn't exist");
				success = false;
			}
		} else {
			success = false;
			//System.out.println("Not enough cash in hand to make deposit of " + amount + " from account " + account);
		}

		return success;
	}

	public boolean makeWithdraw(int account, double amount) {
		boolean success = true;

		if(account == 1 && account1 != null) {
			//System.out.println("Account 1 balance: " + account1.checkBalance());
			success = account1.withdraw(amount);

			if(success == true) {
				cashOnHand += amount;
				//System.out.println("Balance of " + account1.checkBalance());
			} else {
				//System.out.println("Insufficient funds to pull " + amount + " from account " + account);
			}
		} else if(account == 2 && account2 != null) {
			//System.out.println("Account 1 balance: " + account1.checkBalance());
			success = account2.withdraw(amount);

			if(success == true) {
				cashOnHand += amount;
				//System.out.println("Balance of " + account1.checkBalance());
			} else {
				//System.out.println("Insufficient funds to pull " + amount + " from account " + account);
			}
		} else {
			//System.out.println("Account " + account + " doesn't exist.");
			success = false;
		}

		return success;
	}

	public boolean addAccount(int account, double rate, AccountType type) {
		boolean success = true;
		
		if(account == 1) {
			if(account1 == null) {
				account1 = new BankAccount(firstName, lastName, rate, type);
				success = true;
			} else {
				//System.out.println("Account 1 is already taken.");
				success = false;
			}
		} else if (account == 2) {
			if(account2 == null) {
				account2 = new BankAccount(firstName, lastName, rate, type);
				success = true;
			} else {
				//System.out.println("Account 2 is already taken.");
				success= false;
			}
		} else {
			System.out.println("Patron already has two accounts.");
			success = false;
		}

		return success;
	}

	public boolean removeAccount(int account) {
		boolean success = true;

		if(account == 1) {
			if(account1 != null) {
				account1 = null;
				//System.out.println("Removed account1");
				success = true;
			} else {
				//System.out.println("Account 1 could not be deleted.");
				success = false;
			}
		}

		if(account == 2) {
			if(account2 != null) {
				account2 = null;
				//System.out.println("Removed account2");
				success = true;
			} else {
				//System.out.println("Account 2 could not be deleted.");
				success = false;
			}
		}

		return success;
	}
	/*
	public boolean removePatron (String firstName, String lastName) {
		boolean success = true;

		//What does removing a patron mean?
		return success;
	}

	public BankPatron returnPatron (String patronFirstName, String patronLastName) {
		if(patronFirstName.equals(firstName) && patronLastName.equals(lastName)) {
			return BankPatron;
		} else {
			System.out.println("Can't find patron.");
			return null;
		}
	}
	*/
}
