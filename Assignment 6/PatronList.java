public class PatronList {
	private BankPatron one;
	private BankPatron two;
	private BankPatron three;
	private BankPatron four;
	private BankPatron five;

	//variable shared between lookupPatron and overloaded patronInfo(strings)
	private int patronNum;

	public PatronList() {
		one = null;
		two = null;
		three = null;
		four = null;
		five = null;

		patronNum = 0;
	}

	public int firstAvailablePatron () {
		int firstNull;

		firstNull = 0;

		if(one == null) {
			firstNull = 0;
			//System.out.println("First slot null");
		} else if (two == null) {
			firstNull = 1;
			//System.out.println("Second slot null");
		} else if (three == null) {
			firstNull = 2;
			//System.out.println("Third slot null");
		} else if (four == null) {
			firstNull = 3;
			//System.out.println("Fourth slot null");
		} else if (five == null) {
			firstNull = 4;
			//System.out.println("Fifth slot null");
		} else if (one != null && two != null && three != null && four != null && five != null) {
			firstNull = -1;
			//System.out.println("No slot available.");
		}

		return firstNull;
	}

	//currently unused
	public boolean isEmpty() {
		boolean no_patrons = true;

		if (one == null && two == null && three == null && four == null && five == null) {
			no_patrons = true;
		} else {
			no_patrons = false;
		}

		return no_patrons;
	}

	public boolean addPatron(BankPatron addedPatron) {
		boolean success = true;
		int firstSlot = firstAvailablePatron();

		if(firstSlot != -1) {
			switch(firstSlot){	
				case 0:
					one = addedPatron;
					//System.out.println("Added patron to first slot.");
					success = true;
					break;
				case 1:
					two = addedPatron;
					//System.out.println("Added patron to second slot.");
					success = true;
					break;
				case 2:
					three = addedPatron;
					//System.out.println("Added patron to third slot.");
					success = true;
					break;
				case 3: 
					four = addedPatron;
					//System.out.println("Added patron to fourth slot.");
					success = true;
					break;
				case 4:
					five = addedPatron;
					//System.out.println("Added patron to fifth slot.");
					success = true;
					break;
			}
		} else {
			//System.out.println("No patron slot available.");
			success = false;
		}

		return success;
	}

	//Can only be one line????
	public boolean addPatron(String addFirstName, String addLastName, double addSalary, double addCashOnHand) { boolean success = true; return success; }

	public boolean removePatron(int patron_number) {
		boolean success = true;

		switch(patron_number) {
			case 0:
				one = null;
				success = true;
				break;
			case 1: 
				two = null;
				success = true;
				break;
			case 2:
				three = null;
				success = true;
				break;
			case 3:
				four = null;
				success = true;
				break;
			case 4:
				five = null;
				success = true;
				break;
			default:
				//System.out.println("Patron doesn't exist");
				success = false;
				break;
		}

		return success;
	}

	//this isn't an assignment-specified method, but it's useful in removing a patron
	public int lookupPatronNum (String lookupFirstName, String lookupLastName) {

		if(one != null && one.getPatronName().equals(lookupFirstName + " " + lookupLastName)) {
			patronNum = 0;
		} else  if (two != null && two.getPatronName().equals(lookupFirstName + " " + lookupLastName)) {
			patronNum = 1;
		} else if (three != null && three.getPatronName().equals(lookupFirstName + " " + lookupLastName)) {
			patronNum = 2;
		} else if (four != null && four.getPatronName().equals(lookupFirstName + " " + lookupLastName)) {
			patronNum = 3;
		} else if (five != null && five.getPatronName().equals(lookupFirstName + " " + lookupLastName)) {
			patronNum = 4;
		} else {
			//System.out.println("lookupPatron: failed");
			patronNum = -1;
		}

		return patronNum;
	}

	public BankPatron lookupPatron (int lookupPatron) {
		BankPatron patron;

		switch (lookupPatron) {
			case 0:
				if(one != null) {
					//System.out.println("Patron set to 1.");
					patron = one;
				} else {
					//System.out.println("Patron doesn't exist.");
					patron = null;
				}
				break;
			case 1:
				if(two != null) {
					//System.out.println("Patron set to 2.");
					patron = two;
				} else {
					//System.out.println("Patron doesn't exist.");
					patron = null;
				}
				break;
			case 2:
				if(three != null) {
					//System.out.println("Patron set to 3.");
					patron = three;
				} else {
					//System.out.println("Patron doesn't exist.");
					patron = null;
				}
				break;
			case 3:
				if(four != null) {
					//System.out.println("Patron set to 4.");
					patron = four;
				} else {
					//System.out.println("Patron doesn't exist.");
					patron = null;
				}
				break;
			case 4:
				if(four != null) {
					//System.out.println("Patron set to 5.");
					patron = five;
				} else {
					//System.out.println("Patron doesn't exist.");
					patron = null;
				}
				break;
			default:
				//System.out.println("Can't find patron in lookup.");
				patron = null;
				break;
		}

		return patron;
	}
	
	//What if two patrons have the same name?
	public BankPatron lookupPatron (String lookupFirstName, String lookupLastName) {
		BankPatron patron;

		if(one != null && one.getPatronName().equals(lookupFirstName + " " + lookupLastName)) {
			patron = one;
			patronNum = 0;
		} else  if (two != null && two.getPatronName().equals(lookupFirstName + " " + lookupLastName)) {
			//System.out.println("lookupPatron: 2");
			patron = two;
			patronNum = 1;
		} else if (three != null && three.getPatronName().equals(lookupFirstName + " " + lookupLastName)) {
			//System.out.println("lookupPatron: 3");
			patron = three;
			patronNum = 2;
		} else if (four != null && four.getPatronName().equals(lookupFirstName + " " + lookupLastName)) {
			//System.out.println("lookupPatron: 4");
			patron = four;
			patronNum = 3;
		} else if (five != null && five.getPatronName().equals(lookupFirstName + " " + lookupLastName)) {
			//System.out.println("lookupPatron: 5");
			patron = five;
			patronNum = 4;
		} else {
			//System.out.println("lookupPatron: failed");
			patron = null;
		}

		return patron;

	}
	//it's not clear on the directions what input the method uses to get the patron in question
	//so I overloaded it to take a name or the patron number
	public void patronInfo(String patronFirstName, String patronLastName) {
		BankPatron patronInfo;

		patronInfo = lookupPatron(patronFirstName, patronLastName);

		patronInfo(patronNum);
		
	}
	public String patronInfo(int patronNum) {
		String info;
		BankPatron patron;

		patron = null;
		
		switch(patronNum) {
			case 0:
				//System.out.println("patronInfo: patron is one");
				patron = one;
				break;
			case 1:
				//System.out.println("patronInfo: patron is two");
				patron = two;
				break;
			case 2:
				//System.out.println("patronInfo: patron is three");
				patron = three;
				break;
			case 3:
				//System.out.println("patronInfo: patron is four");
				patron = four;
				break;
			case 4:
				//System.out.println("patronInfo: patron is five");
				patron = five;
				break;
			default:
				//System.out.println("patronInfo: Patron doesn't exist.");
				break;
		}

		info = "";
		
		if(patron != null && patron.account1 != null) {
			//System.out.println("patronInfo: Getting 1");
			info = patron.getPatronName() + " "  +
				"First account: " +
				patron.account1.getType() + " " +
				patron.account1.getAccountNum() + " " +
				"Balance: " +
				patron.account1.checkBalance() + " " +
				"Interest Rate: " +
				patron.account1.getRate() + "\n";
		} else if (patron != null && patron.account1 == null) {
			//System.out.println("patronInfo: patron account 1 NULL");
			info = patron.getPatronName();
		}

		if(patron != null && patron.account2 != null) {
			//System.out.println("patronInfo: Getting 2");
			info = info + patron.getPatronName() + " " +
				"Second account: " +
				patron.account2.getType() + " " +
				patron.account2.getAccountNum() + " " +
				"Balance: " +
				patron.account2.checkBalance() + " " +
				"Interest Rate: " +
				patron.account2.getRate() + "\n";
		} else {
			//System.out.println("patronInfo: patron account 2 NULL");
		}
		
		return info;
	}

	//currently unused
	public String getPatronName(int patron_num) {
		String name;
		BankPatron patron;

		patron = null;
		
		switch(patron_num) {
			case 0:
				patron = one;
				break;
			case 1:
				patron = two;
				break;
			case 2:
				patron = three;
				break;
			case 3:
				patron = four;
				break;
			case 4:
				patron = five;
				break;
			default:
				patron = null;
				break;
		}

		name = "error";

		//Unncessary for else ifs, but just for clarity.
		if(patron != null && patron_num == 0) {
			name = patron.getPatronName();
		} else if (patron != null && patron_num == 1) {
			name = patron.getPatronName();
		} else if (patron != null && patron_num == 2) {
			name = patron.getPatronName();
		} else if (patron != null && patron_num == 3) {
			name = patron.getPatronName();
		} else if (patron != null && patron_num == 4) {
			name = patron.getPatronName();
		} else {
			//Will return "error" as the name
		}

		return name;
	}
}
