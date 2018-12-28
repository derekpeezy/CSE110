import java.util.*;

/*
 * Derek Pezzella
 * October 1st, 2017
 * Assignment 4
 */

public class Assignment4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean bDiamond;
		String iHeight_workaround; //this will be changed to an integer
		int iHeight;
		int iHeight_new;
		int iStarCounter;
		int iSpaceCounter;
		int iLineCounter;
		String strPyramid;

		iStarCounter = 1;
		iSpaceCounter = 1;
		iLineCounter = 1;
		bDiamond = false;

		System.out.println("What is the height of the pyramid? Must be at least 1 and less than or equal to 25.");

		//Getting a weird runtime issue where scan won't take nextLine, so this is the workaround
		iHeight_workaround = scan.nextLine(); 
		iHeight = Integer.parseInt(iHeight_workaround);

		iHeight_new = iHeight;
		
		if(iHeight >= 1 && iHeight <= 25) {
			System.out.println("Would you like a diamond instead of a pyramid?");

			strPyramid = scan.nextLine();
			//strPyramid = strPyramid.toLowerCase();
			strPyramid = strPyramid.replace(" ", "");

			if(strPyramid.equals("Yes")) {
				//print diamond
				bDiamond = true;

			} else if (strPyramid.equals("No")) {
				//print pyramid
				bDiamond = false;
			} else {
				while(!strPyramid.equals("Yes") && !strPyramid.equals("No")) {
					System.out.println("You must answer Yes or No.");

					strPyramid = scan.nextLine();

					//strPyramid = strPyramid.toLowerCase();
					strPyramid = strPyramid.replace(" ", "");

				}

				if(strPyramid.equals("Yes")) {
					bDiamond = true;
				} else if (strPyramid.equals("No")) {
					bDiamond = false;
				}

				iHeight_new = iHeight;
			}

			if(bDiamond == true) {
				System.out.println("Printing diamond of height " + (iHeight*2 - 1) + ".");
				
				//build top of the diamond
				while(iLineCounter <= iHeight) {
					iSpaceCounter = 1;
					iStarCounter = 1;

					while(iSpaceCounter < iHeight_new) {
						System.out.print(" ");

						iSpaceCounter = iSpaceCounter + 1;
					}

					while(iStarCounter <= (iLineCounter*2 - 1)) {
						System.out.print("*");

						iStarCounter = iStarCounter + 1;
					}

					System.out.print("\n");
					iHeight_new = iHeight_new - 1;
					iLineCounter = iLineCounter + 1;
				}


				iLineCounter = 2; //start at 2 so it doesn't reprint bottom row
				iHeight_new = iHeight;
				
				//build bottom of the diamond
				while(iLineCounter <= iHeight) {
					iSpaceCounter = 1;
					iStarCounter = 1;
					
					while(iSpaceCounter <= iLineCounter - 1) { //cut off the top of the diamond so there isn't two middle rows
						System.out.print(" ");
						iSpaceCounter = iSpaceCounter + 1;
					}

					while(iStarCounter < iHeight_new * 2 - 2) { //I don't know why this works, but it does.
						System.out.print("*");

						iStarCounter = iStarCounter + 1;
					}

					System.out.print("\n");
					iHeight_new = iHeight_new - 1;
					iLineCounter = iLineCounter + 1;
				}
			} else {
				//user wants a simple pyramid
				System.out.println("Printing pyramid of height " + iHeight + ".");
				
				while(iLineCounter <= iHeight) {
					iSpaceCounter = 1;
					iStarCounter = 1;

					while(iSpaceCounter < iHeight_new) {
						System.out.print(" ");
						iSpaceCounter = iSpaceCounter + 1;
					}

					while(iStarCounter <= (iLineCounter*2 - 1)) {
						System.out.print("*");
						iStarCounter = iStarCounter + 1;
					}

					System.out.print("\n");
					iHeight_new = iHeight_new - 1;
					iLineCounter = iLineCounter + 1;
				}
			}
		} else {
			while(iHeight > 25 || iHeight < 1) {
				System.out.println("Pyramid height must be greater than 1 and less than 25.");
				System.out.println("What is the height of the pyramid?");

				iHeight_workaround = scan.nextLine(); 
				iHeight = Integer.parseInt(iHeight_workaround);
			}

			iHeight_new = iHeight;

			System.out.println("Would you like a diamond instead of a pyramid?");

			strPyramid = scan.nextLine();
			//strPyramid = strPyramid.toLowerCase();
			strPyramid = strPyramid.replace(" ", "");

			if(strPyramid.equals("Yes")) {
				//print diamond
				bDiamond = true;

			} else if (strPyramid.equals("No")) {
				//print pyramid
				bDiamond = false;
			} else {
				while(!strPyramid.equals("Yes") && !strPyramid.equals("No")) {
					System.out.println("You must answer Yes or No.");

					strPyramid = scan.nextLine();

					//strPyramid = strPyramid.toLowerCase();
					strPyramid = strPyramid.replace(" ", "");

				}

				if(strPyramid.equals("Yes")) {
					bDiamond = true;
				} else if (strPyramid.equals("No")) {
					bDiamond = false;
				}

				//System.out.println("DEV: " + bDiamond);
				iHeight_new = iHeight;
			}

			if(bDiamond == true) {
				System.out.println("Printing diamond of height " + (iHeight*2 - 1) + ".");
				
				//build top of the diamond
				while(iLineCounter <= iHeight) {
					iSpaceCounter = 1;
					iStarCounter = 1;

					while(iSpaceCounter < iHeight_new) {
						System.out.print(" ");

						iSpaceCounter = iSpaceCounter + 1;
					}

					while(iStarCounter <= (iLineCounter*2 - 1)) {
						System.out.print("*");

						iStarCounter = iStarCounter + 1;
					}

					System.out.print("\n");
					iHeight_new = iHeight_new - 1;
					iLineCounter = iLineCounter + 1;
				}


				iLineCounter = 2; //start at 2 so it doesn't reprint bottom row
				iHeight_new = iHeight;
				
				//build bottom of the diamond
				while(iLineCounter <= iHeight) {
					iSpaceCounter = 1;
					iStarCounter = 1;
					
					while(iSpaceCounter <= iLineCounter - 1) { //cut off the top of the diamond so there isn't two middle rows
						System.out.print(" ");
						iSpaceCounter = iSpaceCounter + 1;
					}

					while(iStarCounter < iHeight_new * 2 - 2) { //I don't know why this works, but it does.
						System.out.print("*");

						iStarCounter = iStarCounter + 1;
					}

					System.out.print("\n");
					iHeight_new = iHeight_new - 1;
					iLineCounter = iLineCounter + 1;
				}
			} else {
				//user wants a simple pyramid
				System.out.println("Printing pyramid of height " + iHeight + ".");
				
				while(iLineCounter <= iHeight) {
					iSpaceCounter = 1;
					iStarCounter = 1;

					while(iSpaceCounter < iHeight_new) {
						System.out.print(" ");
						iSpaceCounter = iSpaceCounter + 1;
					}

					while(iStarCounter <= (iLineCounter*2 - 1)) {
						System.out.print("*");
						iStarCounter = iStarCounter + 1;
					}

					System.out.print("\n");
					iHeight_new = iHeight_new - 1;
					iLineCounter = iLineCounter + 1;
				}
			}
		}

		scan.close();

	}
}
