import java.util.Scanner;

/**
 * Derek Pezzella   
 * September 7th, 2017
 * Assignment #2
 */

public class Assignment2
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        
        //initialize variables to be used for string searching
        String strUserInput, strSubstring;
        String strConsiderSpaces, strConsiderCase;
        
        //Get user strings and their preferences for searching with spaces and case
        System.out.println("Please enter a word or phrase.");
        strUserInput = scan.nextLine();
        System.out.println("Please input the string you would like to search for in your word or phrase.");
        strSubstring = scan.nextLine();
        
        System.out.println("Would you like to consider the spaces in the strings?");
        System.out.println("Type a 1 for \"yes\" and type a 0 for \"no\"");
        strConsiderSpaces = scan.nextLine();
        
        System.out.println("Would you like to consider the difference between upper case and lower case?");
        System.out.println("Type a 1 for \"yes\" and type a 0 for \"no\"");
        strConsiderCase = scan.nextLine();
        
        //Put their spacing and case choices into integers
        int iConsiderSpaces = Integer.parseInt(strConsiderSpaces);
        int iConsiderCase = Integer.parseInt(strConsiderCase);
        
        //Search strings based upon their spacing and case choices
        //user wants original spacing and case
        if(iConsiderSpaces == 1 && iConsiderCase == 1) {
        	//string and searching string are identical
            if (strUserInput.contentEquals(strSubstring)) {
            	System.out.println("Your string is identical to the search string.");
            } else if (strUserInput.startsWith(strSubstring)) { //search string appears at the beginning
            	System.out.println("The search string is at the beginning of your string.");
            } else if (strUserInput.endsWith(strSubstring)) { //search string appears the the ending
            	System.out.println("The search string is at the ending of your string.");
            } else if (strUserInput.indexOf(strSubstring) == -1){ //search string is not in the string at all
            	System.out.println("The search string is not in your string.");
            } else { //search string appears somewhere other than beginning or end
            	System.out.println("The search string begins at position " + strUserInput.indexOf(strSubstring) 
            			+ " and ends at position " + (strUserInput.indexOf(strSubstring) + strSubstring.length() - 1)
            			+ ".");
            }
        //user wants ignore spacing and case
        } else if (iConsiderSpaces == 0 && iConsiderCase == 0) {
        	strUserInput = strUserInput.toLowerCase();
        	strSubstring = strSubstring.toLowerCase();
        	
        	strUserInput = strUserInput.replace(" ", "");
        	strSubstring = strSubstring.replace(" ", "");
        	
        	if (strUserInput.contentEquals(strSubstring)) {
            	System.out.println("Your string is identical to the search string.");
            } else if (strUserInput.startsWith(strSubstring)) {
            	System.out.println("The search string is at the beginning of your string.");
            } else if (strUserInput.endsWith(strSubstring)) {
            	System.out.println("The search string is at the ending of your string.");
            } else if (strUserInput.indexOf(strSubstring) == -1){
            	System.out.println("The search string is not in your string.");
            } else {
            	System.out.println("The search string begins at position " + strUserInput.indexOf(strSubstring) 
            			+ " and ends at position " + (strUserInput.indexOf(strSubstring) + strSubstring.length() - 1)
            			+ ".");
            }
        //user wants to consider original spacing but ignore casing
        } else if (iConsiderSpaces == 1 && iConsiderCase == 0) {
        	strUserInput = strUserInput.toLowerCase();
        	strSubstring = strSubstring.toLowerCase();
        	
        	if (strUserInput.contentEquals(strSubstring)) {
            	System.out.println("Your string is identical to the search string.");
            } else if (strUserInput.startsWith(strSubstring)) {
            	System.out.println("The search string is at the beginning of your string.");
            } else if (strUserInput.endsWith(strSubstring)) {
            	System.out.println("The search string is at the ending of your string.");
            } else if (strUserInput.indexOf(strSubstring) == -1){
            	System.out.println("The search string is not in your string.");
            } else {
            	System.out.println("The search string begins at position " + strUserInput.indexOf(strSubstring) 
            			+ " and ends at position " + (strUserInput.indexOf(strSubstring) + strSubstring.length() - 1)
            			+ ".");
            }
        //user wants to ignore spacing, but consider casing
        } else if (iConsiderSpaces == 0 && iConsiderCase == 1) {
        	strUserInput = strUserInput.replace(" ", "");
            strSubstring = strSubstring.replace(" ", "");
        	
            if (strUserInput.contentEquals(strSubstring)) {
            	System.out.println("Your string is identical to the search string.");
            } else if (strUserInput.startsWith(strSubstring)) {
            	System.out.println("The search string is at the beginning of your string.");
            } else if (strUserInput.endsWith(strSubstring)) {
            	System.out.println("The search string is at the ending of your string.");
            } else if (strUserInput.indexOf(strSubstring) == -1){
            	System.out.println("The search string is not in your string.");
            } else {
            	System.out.println("The search string begins at position " + strUserInput.indexOf(strSubstring) 
            			+ " and ends at position " + (strUserInput.indexOf(strSubstring) + strSubstring.length() - 1)
            			+ ".");
            }
        }
        scan.close();
    }
}
