import java.util.*;

/*
 * Derek Pezzella
 * Assignment 3
 * September 24th, 2017
*/

public class Assignment3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        int iNumInputs;
        double dblInputSum;
        double dblLastInput;
        double dblHighestInput;
        double dblLowestInput;
        
        //set last input to 1 so loop is initiated for user input
        dblLastInput = 1;
        iNumInputs = 0;
        dblInputSum = 0;

        dblLowestInput = Integer.MAX_VALUE;
	dblHighestInput = -Integer.MAX_VALUE;
       
        System.out.println("Type in values with decimals.\n");
        System.out.println("Type 0 when finished.");
        
        while (dblLastInput != 0) {
            dblLastInput = scan.nextDouble();
            
            //Dr. Baron said this is bad stylistically, but it's the easiest way
            //so 0 doesn't get stored!
            if (dblLastInput == 0) { break; }

            dblInputSum += dblLastInput;

	    if (dblLastInput > dblHighestInput) {
		    dblHighestInput = dblLastInput;
	    } 
	    if (dblLastInput < dblLowestInput) {
		    dblLowestInput = dblLastInput;
	    }
	   
            iNumInputs += 1;
        }
        
	if(iNumInputs != 0) {
        	System.out.println("Sum of all inputs: " + dblInputSum);
        	System.out.println("Total number of all inputs: " + iNumInputs);
        	System.out.println("Average number of inputs: "
            		+ (dblInputSum/iNumInputs));
       		System.out.println("Highest input: " + dblHighestInput);
        	System.out.println("Lowest input: " + dblLowestInput);
	} else {
		System.out.println("You didn't put anything in.");
	}
        
        scan.close();
    }
}

