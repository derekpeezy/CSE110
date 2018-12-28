import java.util.Scanner;

public class Assignment6 {

	public static Scanner scan = new Scanner(System.in);
	public static PatronList patron_list;

	//When returning to main menu from the patron menu, the main menu doesn't accept
	//input for the first input. This lets the main_menu method know that the user is coming
	//from the patron menu, so it passes a fake input value ("k") so it skips that first time input.
	public boolean stupid_menu_hack = false;

	public static void main(String[] args) {
		patron_list = new PatronList();

		Assignment6 assignment6 = new Assignment6();
		
		qp("Welcome to the CSE 110 bank!");
		String menu_input = assignment6.main_menu();

		while(!menu_input.equals("e")) {
			if(menu_input.equals("a")) {
				int first_available = 0;
				//boolean is_empty = false;
				String patron_info = "";

				first_available = patron_list.firstAvailablePatron();

				if(first_available == -1) { first_available = 5; }
				
				if(!patron_list.isEmpty()) {
					qp("Patrons currently at the bank:");
					for(int i = 0; i < first_available; i++) {
						//patron_info = patron_list.getPatronName(i);
						patron_info = patron_list.patronInfo(i);
						qp(patron_info);
					}
				} else {
					qp("None");
				}
			} else if(menu_input.equals("b")) {
				qp("What is the first name of the new patron?");
				String patronFirstName = scan.nextLine();

				qp("Their last name?");
				String patronLastName = scan.nextLine();

				qp("Their yearly salary?");
				double salary = scan.nextDouble();
				scan.nextLine();

				qp("How much cash do they have on hand?");
				double cashOnHand = scan.nextDouble();
				scan.nextLine();

				//creating a bank patron then passing it along
				//for the meantime; I can't figure out the "one line" addPatron method
				BankPatron new_patron = new BankPatron(patronFirstName, patronLastName, salary, cashOnHand);

				boolean add_patron = patron_list.addPatron(new_patron);
				
				if(add_patron == false) {
					qp("Could not add patron. The bank is full.");
				} else {
					qp("Welcome to the bank, " + patronFirstName + ".");
				}
			} else if(menu_input.equals("d")) {
				qp("What is the patron's first name?");
				String patronMenuFirstName = scan.nextLine();

				qp("What is the patron's last name?");
				String patronMenuLastName = scan.nextLine();
				
				BankPatron patron_menu = patron_list.lookupPatron(patronMenuFirstName, patronMenuLastName);
				
				if(patron_menu == null) {
					qp("Cannot find patron");
				} else {
					qp("What do you want to do with " + patronMenuFirstName + "  " + patronMenuLastName);
					assignment6.handle_patron_menu(patron_menu);
				}
			} else if(menu_input.equals("c")) {
				int patron_num = 0;

				qp("Type the first name of the patron you want");
				String patronRemoveFirstName = scan.nextLine();

				qp("Type the last name of the patron you want.");
				String patronRemoveLastName = scan.nextLine();

				patron_num = patron_list.lookupPatronNum(patronRemoveFirstName, patronRemoveLastName);
				
				boolean remove_patron = patron_list.removePatron(patron_num);

				if(remove_patron == false) {
					qp("There is no patron by that name.");
				} else {
					qp(patronRemoveFirstName + " " + patronRemoveLastName + " has left the bank.");
				}
			} else {
				qp("Invalid input.");
			}
			menu_input = assignment6.main_menu();
		}
	}

	public String main_menu () {
		String input = "";

		if(stupid_menu_hack == true) { 
			input = "k";
			stupid_menu_hack = false;
		} else {
			String menu = "a. List Patrons\n" +
		 		"b. Add New Patron\n" +
		 		"c. Remove Patron\n" +
		 		"d. Patron Specific Actions\n" +
		 		"e. Quit\n";
			qp(menu);
			input = scan.nextLine();
		}

		if(input.equals("e")) {
			qp("Thank you for coming.");
			System.exit(0);
		}

		return input;
	}

	public String patron_menu () {
		String menu = "a. Add New Account\n" +
			"b. Close Account\n" +
			"c. Get Paid\n" +
			"d. Apply Interest to Accounts\n" +
			"e. Make Deposit\n" +
			"f. Make Withdraw\n" +
			"g. Return to Main Menu\n";

		qp(menu);

		String input = scan.nextLine();

		return input;
	}

	public void handle_patron_menu(BankPatron patron) {
		String patron_input = patron_menu();

		while(!patron_input.equals("g")) {
			qp("What do you want to do with " + patron.getPatronName());
			if(patron_input.equals("a")) {
				//add new account
				double interest_rate;
				AccountType acct_type;
				boolean added_account = true;

				qp("Which account type did you want?");
				acct_type = account_menu();

				qp("Please input the interest rate.");
				interest_rate = scan.nextDouble();
				scan.nextLine();

				if(patron.account1 == null) {
					//qp("handle_patron_menu: null 1");
					added_account = patron.addAccount(1, interest_rate, acct_type);

					if(added_account == true) {
						qp("Account successfully added!");
					} else {
						qp("Account could not be added!");
					}
				} else if (patron.account2 == null) {
					//qp("handle_patron_menu: null 2");
					added_account = patron.addAccount(2, interest_rate, acct_type);

					if(added_account == true) {
						qp("Account successfully added!");
					} else {
						qp("Account could not be added!");
					}
				} else {
					qp("Account could not be added!");
				}
			} else if(patron_input.equals("b")) {
				//close account
				qp("Type the number of the account you would like to remove.");
				int acct = scan.nextInt();
				scan.nextLine();
				
				if(acct == 1 && patron.account1 != null) {
					qp("Account 1 successfully closed.");
					patron.account1 = null;
				} else if (acct == 2 && patron.account2 != null) {
					qp("Account 2 successfully closed.");
				} else if (acct == 1 && patron.account1 == null) {
					qp("Account 1 does not exist.");
				} else if (acct == 2 && patron.account2 == null) {
					qp("Cannot close specified account.");
				}
			} else if(patron_input.equals("c")) {
				//get paid
				patron.issuePaycheck();
				//qp("Recieved paycheck for " + patron.getSalary()/26 + ".");
			} else if(patron_input.equals("d")) {
				//apply interest
				
				qp("Type the number of the account you would like to apply interest.");
				int interest_acct = scan.nextInt();
				scan.nextLine();

				if(interest_acct == 1 && patron.account1 != null) {
					patron.account1.applyInterest();
					qp("Interest applied to account 1.");
				} else if (interest_acct == 1 && patron.account1 == null) {
					qp("Unable to apply interest. Account 1 doesn't exist.");
				}

				if(interest_acct == 2 && patron.account2 != null) {
					patron.account2.applyInterest();
				} else if (interest_acct == 2 && patron.account2 == null ) {
					qp("Unable to apply interest. Account 2 doesn't exist.");
				}
				
			} else if(patron_input.equals("e")) {
				//make deposit
				boolean make_deposit = true;
				qp("Which account (1 or 2) would you like to make a deposit in?");
				int acct = scan.nextInt();
				scan.nextLine();

				qp("How much would you like to deposit?");
				double amount = scan.nextDouble();
				scan.nextLine();

				if(acct == 1 && patron.account1 != null) {
					make_deposit = patron.makeDeposit(acct, amount);

					if(make_deposit == true) {
						qp("Successfully deposited $" + amount + " into account " + acct);
					} else {
						qp("Patron does not have enough cash on hand!");
					}
				} else if(acct == 2 && patron.account2 != null) {
					make_deposit = patron.makeDeposit(acct, amount);

					if(make_deposit == true) {
						qp("Successfully deposited $" + amount + " into account " + acct);
					} else {
						qp("Patron does not have enough cash on hand!");
					}
				} else if (acct == 1 && patron.account1 == null) {
					qp("Account 1 does not exist.");
				} else if (acct == 2 && patron.account2 == null) {
					qp("Account 2 does not exist.");
				} else {
					qp("Cannot make deposit.");
				}
			} else if(patron_input.equals("f")) {
				//make withdraw
				qp("Which account would you like to make a withdraw for?");
				int acct = scan.nextInt();
				scan.nextLine();

				qp("How much would you like to withdraw?");
				double amount = scan.nextDouble();
				scan.nextLine();

				if(acct == 1 && patron.account1 != null) {
					patron.makeWithdraw(acct, amount);
					qp("Successfully withdrew $" + amount + " into account " + acct);
				} else if(acct ==2 && patron.account2 != null) {
					patron.makeWithdraw(acct, amount);
					qp("Successfully withdrew $" + amount + " into account " + acct);
				} else if (acct == 1 && patron.account1 == null) {
					qp("Account 1 does not exist.");
				} else if (acct == 2 && patron.account2 == null) {
					qp("Account 2 does not exist.");
				} else {
					qp("Cannot make deposit.");
				}
			} else {
				qp("Invalid input. Please enter a letter from the menu.");
			}

			patron_input = patron_menu();
		}

		if(patron_input.equals("g")) {
			//return to main menu
			stupid_menu_hack = true;
			main_menu();
		}
	}

	public AccountType account_menu () {
		String menu = "a. Checking\n" +
			"b. Savings\n" +
			"c. CD\n" +
			"d. Money Market\n" +
			"e. IRA\n";
		AccountType type;

		type = AccountType.Checking;

		qp(menu);

		String input = scan.nextLine();

		if(!input.equals("a") && !input.equals("b") && !input.equals("c") && !input.equals("d")
				&& !input.equals("e")) {
					qp("Invalid input. Please enter in a letter for the menu choice.");
					account_menu();
				}

		if(input.equals("a")) {
			type = AccountType.Checking;
		} else if(input.equals("b")) {
			type = AccountType.Savings;
		} else if(input.equals("c")) {
			type = AccountType.CD;
		} else if(input.equals("d")) {
			type = AccountType.MoneyMarket;
		} else if(input.equals("e")) {
			type = AccountType.IRA;
		}

		return type; 
	}


	public static void test () {
		String test_firstName = "Derek";
		String test_lastName  = "Pezzella";
		double test_salary = 50000.0;
		double test_cash = 4000.0;
		AccountType ty;

		BankPatron patron_test = new BankPatron(test_firstName, test_lastName, test_salary, test_cash);

		//testing for PatronList
		BankPatron patron_test2 = new BankPatron(test_firstName, test_lastName, test_salary, test_cash);
		BankPatron patron_test3 = new BankPatron(test_firstName, test_lastName, test_salary, test_cash);
		BankPatron patron_test4 = new BankPatron(test_firstName, test_lastName, test_salary, test_cash);
		BankPatron patron_test5 = new BankPatron(test_firstName, test_lastName, test_salary, test_cash);
		BankPatron patron_test6 = new BankPatron(test_firstName, test_lastName, test_salary, test_cash);

		patron_test.addAccount(1, 0.4, AccountType.Checking);
		patron_test.addAccount(2, 0.4, AccountType.Savings);

		qp(patron_test.getPatronName());
		qp(patron_test.getSalary());
		qp(patron_test.getCashOnHand());
		patron_test.issuePaycheck();
		qp(patron_test.getCashOnHand());
		patron_test.getAccount(1);
		patron_test.getAccount(2);
		patron_test.getAccount(3);

		patron_test.makeWithdraw(1, 10);
		patron_test.makeWithdraw(2, 10);
		patron_test.makeWithdraw(3, 10);
		patron_test.makeWithdraw(1, 10^10);

		patron_test.makeDeposit(1, 100);
		patron_test.makeDeposit(2, 100);
		patron_test.makeDeposit(3, 10);
		patron_test.makeDeposit(1, 10^10);

		//patron_test.returnPatron("Derek", "Pezzella");

		patron_test.removeAccount(1);
		patron_test.removeAccount(2);
		
		patron_test.addAccount(1, 0.4, AccountType.Checking);
		patron_test.addAccount(2, 0.4, AccountType.Savings);

		PatronList test_bank = new PatronList();

		test_bank.addPatron(patron_test);
		test_bank.addPatron(patron_test2);
		test_bank.addPatron(patron_test3);
		test_bank.addPatron(patron_test4);
		test_bank.addPatron(patron_test5);
		test_bank.addPatron(patron_test6); //should fail

		patron_test2 = test_bank.lookupPatron(1);
		//make sure can access patron_test2's class after setting it
		qp(patron_test2.getPatronName());

		//If two patrons have the same name, the first account that has that name will be returned.
		patron_test = test_bank.lookupPatron("Derek", "Pezzella");

		test_bank.patronInfo(0);
		test_bank.patronInfo("Derek", "Pezzella");
	}

	public static void qp(String qp) { System.out.println(qp); }
	public static void qp(int qp) { System.out.println(qp); }
	public static void qp(double qp) { System.out.println(qp); }
	
}
