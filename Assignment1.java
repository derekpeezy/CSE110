import java.util.*;
import java.math.*;

/**
 * Assignment #1
 *
 * Derek Pezzella
 * August 31st, 2017
 */
public class Assignment1
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        double dblVelocity;
        double dblAngle;
        double dblDistance;
        double dblElevation;
        double dblSize;
        double dblTime;
        double dblProjectileHeight;
        
        String strProjMsg;
        
        //get user input
        System.out.println("Please enter the velocity.");
        dblVelocity = scan.nextDouble();
        
        System.out.println("Please enter the angle in degrees.");
        dblAngle = scan.nextDouble();
        //convert the degrees to radians
        dblAngle = Math.toRadians(dblAngle);
        
        System.out.println("Please enter the distance.");
    	dblDistance = scan.nextDouble();
    
    	System.out.println("Please enter the elevation.");
    	dblElevation = scan.nextDouble();
    
    	System.out.println("Please enter the size.");
    	dblSize = scan.nextDouble();
    	
    	//exit the program if the denominator of the time calculation is going to be zero
        if ((dblVelocity * Math.cos(dblAngle)) == 0) {
        	System.out.println("The distance cannot be calculated with this input.");
            System.exit(-1);
        } else {
        	//calculate the time it takes the object to reach the distance
        	dblTime = dblDistance/(dblVelocity*Math.cos(dblAngle));
        	
        	//calculate projectile height
        	dblProjectileHeight = (dblVelocity * dblTime * Math.sin(dblAngle)) - ((32.17 * dblTime * dblTime)/2.0);
        	
        	if (dblProjectileHeight < 0) {
        		System.out.println("The cannonball did not reach the target.");
        	} else if (dblProjectileHeight > 0 && dblProjectileHeight < dblElevation ){
        		strProjMsg = "The cannonball at height " + dblProjectileHeight + " went under the target.";
        		System.out.println(strProjMsg);
        	} else if (dblProjectileHeight > dblElevation && dblProjectileHeight < dblElevation + dblSize) {
        		System.out.println("The cannonball hit the target.");
        	} else if (dblProjectileHeight > dblElevation + dblSize) {
        		strProjMsg = "The cannonball at height " + dblProjectileHeight + " went over the top of the target.";
        		System.out.println(strProjMsg);
        	}
        }
        
    }
}