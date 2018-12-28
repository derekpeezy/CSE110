import java.util.*;

public class Assignment7 {
	static Scanner scan = new Scanner(System.in);
	static String input = "";

	public static void main(String[] args) {
		//test();
		MyString string = new MyString();
		String searchable = "";
		
		System.out.println("Hi. Welcome to the string searcher.");

		mainMenu();

		while(!input.equals("d")) {
			if(input.equals("a")) {
				System.out.println("Enter your searchable string.");
				searchable = scan.nextLine();
				
				string.setContent(searchable);

				System.out.println("Set " + string.getContent() + " as the searchable string.");
			} else if(input.equals("b")) {
				if(!string.isEmpty) {
					System.out.println(string.getContent());
				}
			} else if(input.equals("c")) {
				searchString(string);
			}

			mainMenu();
		}

		System.out.println("Goodbye!");
	}

	private static void searchString(MyString string) {
		System.out.println("Please enter a string to search.");

		String search = scan.nextLine();

		if(string.contains(search)) {
			if(string.equals(search)) {
				System.out.println("The search string and the original string are identical.");
			} else if (string.startsWith(search)) {
				System.out.println("The search string starts at the original string.");
			} else if (string.endsWith(search)) {
				System.out.println("The original string ends with the search string.");
			} else if (string.indexOf(search) != -1) {
				System.out.println("The search string is in the original string at " + (string.indexOf(search) - 1));
			}
		} else { 
			System.out.println("The search string is not in the original string.");
		}
	}

	private static String mainMenu() {
		System.out.println();
		
		System.out.println("What would you like to do?");
		System.out.println("a. Create a Searchable String\n" +
				"b. Print the current Searchable String\n" +
				"c. Search within the String\n" +
				"d. Quit");

		input = scan.nextLine();

		if(!input.equals("a") && !input.equals("b") && !input.equals("c") && !input.equals("d")) {
			System.out.println("Invalid input.");
		}

		
		return input;
	}

	static void test() {
		char[] test_array = {'d', 'i', 'f', 'f', 'e', 'r', 'e', 'n', 't', 'i', 'a', 'l'};
		
		MyString char_test = new MyString("differential");

		int pos_test = char_test.indexOf("diff");
		System.out.println(pos_test);

		int pos_test2 = char_test.indexOf("xyz");
		System.out.println(pos_test2);

		int pos_test3 = char_test.indexOf("tial");
		System.out.println(pos_test3);

		boolean pos_test4 = char_test.startsWith("diff");
		System.out.println(pos_test4);

		boolean pos_test5 = char_test.startsWith("xyz");
		System.out.println(pos_test5);

		boolean pos_test6 = char_test.endsWith("tial");
		System.out.println(pos_test6);

		boolean pos_test7 = char_test.endsWith("xyz");
		System.out.println(pos_test7);

		boolean pos_test8 = char_test.contains("diff");
		System.out.println(pos_test8);

		boolean pos_test9 = char_test.contains("xyz");
		System.out.println(pos_test9);

		String str_test = char_test.toStringCSE(test_array);
		System.out.println(str_test);
	}
}
