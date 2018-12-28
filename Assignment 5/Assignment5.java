import java.util.*;

public class Assignment5
{
	static Scanner scan = new Scanner(System.in);

	private static String menu() {
		String menu_input;
		String menu = "Type in a letter to make your selection.\n"
				+ "A. List the pets in the store.\n"
				+ "B. Age up the pets.\n"
				+ "C. Add a new pet.\n"
				+ "D. Adopt a pet.\n"
				+ "E. Quit.\n";
		
		qp(menu);
		menu_input = scan.nextLine();
	
		if(!menu_input.equals("A") && !menu_input.equals("B") && !menu_input.equals("C") && !menu_input.equals("D")
        		&& !menu_input.equals("E")) {
			qp("Invalid input. Please enter a letter from the menu.");
		} 
		
		return menu_input;
	}
	
	//quick print methods that shorten printing for me
	static public void qp(String qp) {
		System.out.println(qp);
	}
	static public void qp(int qp) {
		System.out.println(qp);
	}
	static public void qp(boolean qp) {
		System.out.println(qp);
	}
	
	public static void main(String[] args) {
    	Pet fido = new Pet("Fido",3);
    	Pet furball = new Pet("Furball", 1);
    	Pet user_pet;
    	String menu_input;
    	String user_pet_name;
    	int user_pet_age;
    	int user_adopt_num;
    	
    	user_pet = null;
    	menu_input = "";
    	user_pet_name = "";
    	user_pet_age = 0;
    	
    	qp("Welcome to the pet store!");
    	
    	while(!menu_input.equals("E")) {
    		menu_input = menu();
    		
    		if(menu_input.equals("A")) {
    			if(fido.getAge() != 1 && fido.getAdoptedStatus() == false) {
    				qp("Fido is " + fido.getAge() + " years old and is not adopted");
    			} else if (fido.getAge() == 1 && fido.getAdoptedStatus() == false) {
    				qp("Fido is " + fido.getAge() + " year old and is not adopted");
    			} else if (fido.getAge() != 1 && fido.getAdoptedStatus() == true) {
    				qp("Fido is " + fido.getAge() + " years old and is adopted");
    			} else if (fido.getAge() == 1 && fido.getAdoptedStatus() == true) {
    				qp("Fido is " + fido.getAge() + " year old and is adopted");
    			}
    			
    			if(furball.getAge() != 1 && furball.getAdoptedStatus() == false) {
    				qp("Furball is " + furball.getAge() + " years old and is not adopted");
    			} else if (furball.getAge() == 1 && furball.getAdoptedStatus() == false) {
    				qp("Furball is " + furball.getAge() + " year old and is not adopted");
    			} else if (furball.getAge() != 1 && furball.getAdoptedStatus() == true) {
    				qp("Furball is " + furball.getAge() + " years old and is adopted");
    			} else if (furball.getAge() == 1 && furball.getAdoptedStatus() == true) {
    				qp("Furball is " + furball.getAge() + " year old and is adopted");
    			}
    			
    			if(user_pet != null) {
    				if(user_pet.getAge() != 1 && user_pet.getAdoptedStatus() == false) {
        				qp(user_pet.getName() + " is " + user_pet.getAge() + " years old and is not adopted");
        			} else if (user_pet.getAge() == 1 && user_pet.getAdoptedStatus() == false) {
        				qp(user_pet.getName() + " is " + user_pet.getAge() + " year old and is not adopted");
        			} else if (user_pet.getAge() != 1 && user_pet.getAdoptedStatus() == true) {
        				qp(user_pet.getName() + " is " + user_pet.getAge() + " years old and is adopted");
        			} else if (user_pet.getAge() == 1 && user_pet.getAdoptedStatus() == true) {
        				qp(user_pet.getName() + " is " + user_pet.getAge() + " year old and is adopted");
        			}
    			}
    			
    		} else if (menu_input.equals("B")){
    			fido.setAge();
    			furball.setAge();
    			if(user_pet != null) { user_pet.setAge(); }
    			qp("Everyone just got a little older.");
    		} else if (menu_input.equals("C")) {
    			if(user_pet != null) {
    				qp("Sorry, the store is full.");
    			} else {
    				qp("Enter the pet name.");
    				user_pet_name = scan.nextLine();
    				qp("Enter the age of the pet.");
    				user_pet_age = scan.nextInt();
    				scan.nextLine(); //eat the new line
    				
    				user_pet = new Pet(user_pet_name, user_pet_age);
    				qp(user_pet.getName() + " has arrived in the store.");
    			}
    		} else if (menu_input.equals("D")) {
    			
    			if(user_pet != null) {
    				qp("Enter the number of the pet you want to adopt.");
    				qp("1. Fido");
    				qp("2. Furball");
    				qp("3. " + user_pet.getName());
    			} else {
    				qp("Enter the number of the pet you want to adopt.");
    				qp("1. Fido");
    				qp("2. Furball");
    			}
    			
    			user_adopt_num = scan.nextInt();
    			scan.nextLine(); //Eat the new line
    		
    			if(user_adopt_num == 1) {
    				if(!fido.getAdoptedStatus()) {
    					fido.setAdoptedStatus();
    					qp("You adopted Fido.");
    				} else {
    					qp("You already adopted Fido.");
    				}
    			} else if (user_adopt_num == 2) {
    				if(!furball.getAdoptedStatus()) {
    					furball.setAdoptedStatus();
    					qp("You adopted Furball.");
    				} else {
    					qp("You already adopted Furball.");
    				}
    			} else if (user_adopt_num == 3) {
    				if(user_pet != null) {
    					if (!user_pet.getAdoptedStatus()) {
    						user_pet.setAdoptedStatus();
    						qp("You adopted " + user_pet.getName() + ".");
    					} else {
    						qp("You already adopted " + user_pet.getName() + ".");
    					}
    				} else {
    					qp("You haven't added a pet yet.");
    				}
    			} else {
    				qp("You haven't entered a valid pet number.");
    			}
    		}
    	}
    	
    	qp("Goodbye!");
        scan.close();
    }
}
