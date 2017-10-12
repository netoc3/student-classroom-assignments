/**
 * Assignment 1 question 2
 * WoodenBeam Class

 * 
 * @author Francis Okoye 100584156
 * @date 11 Oct 2017
 */

public class WoodenBeam 
{
    /** declaring variables
     */
    double maxLoad; //(L)is the maximum weight in lbs of the load placed on the beam.
    double stress; //(S)is the stress in lbs/in^2.
    double momentOfInertia; //(I)is the beam's rectangular moment of inertia in units of in^4.
    double distance; //(d)is the distance in inches that the load is placed from the fixed end of the beam(the "moment arm").
    double halfHeight; //(c)is one-half the height in inches of the symmetrical beam. 
    double length; //beam length
    double base; //beam base
    double height; //beam height
    /**default constructor with it's arguments
     * @param length
     * @param base
     * @param height
     */
	WoodenBeam( double length , double base , double height)
	{
	this.length = 12*length;
	this.base = base;
	this.height = height;
	
	computeHalfHeight(height); // halfHeight method
	computeInertia(base , height); // computeInertia method
	}
    /** computeMaxLoad() method with it's arguments
     * @param stress
     * @return
     */
	double computeMaxLoad(double stress)
	{
	this.stress = stress;
	
	maxLoad =(stress*momentOfInertia)/(length*halfHeight);
	return maxLoad;
	}
	
	/**computeInertia() method with it's arguments
	 * @param base
	 * @param height
	 */
	void computeInertia(double base,double height)
	{
	momentOfInertia = (base*height*height*height)/(12); //for the wooden beam, the rectangular moment of inertia is given 
	}
	/** computeHalfHeight() method with one argument
	 * @param height
	 */
	void computeHalfHeight(double height)
	{
	halfHeight = height/2; //formula for half life is used.
	}

	public static void main(String args[])
	{
	//create a beam object using it's length, base and height
	WoodenBeam wb1 = new WoodenBeam(8.0, 2.0, 4.0);
	WoodenBeam wb2 = new WoodenBeam(8.0, 3.0, 6.0);
	double maxload1 = wb1.computeMaxLoad(3000.0); 
	double maxload2 = wb2.computeMaxLoad(3000.0);

	System.out.println("For Beam #1:");
	System.out.println("The length of the beam is d = 8 feet which is equal to "+wb1.length+" inches");
	System.out.println("The length of the base is b = "+wb1.base+" inches");
	System.out.println("The height of the beam is h = "+wb1.height+" inches");
	System.out.println("The stress on the fixed end of the beam is S = "+wb1.stress+" lbs per square inch");
	System.out.printf("The rectangular moment of inertia is: %.2f",wb1.momentOfInertia);
	System.out.println(" in^4");
	System.out.println("The centroid of the beam is: "+wb1.base+" inches");
	System.out.printf("Using the formula L = (S*I)/(d*c) = (3000*10.67)/(96*2) , the maximum load that can be placed at the end of the beam is: %.2f",wb1.maxLoad);
	System.out.println(" lbs\n\n");

	System.out.println("For Beam #2:");
	System.out.println("The length of the beam is d = 8 feet which is equal to "+wb2.length+" inches");
	System.out.println("The length of the base is b = "+wb2.base+" inches");
	System.out.println("The height of the beam is h = "+wb2.height+" inches");
	System.out.println("The stress on the fixed end of the beam is S = "+wb2.stress+" lbs per square inch");
	System.out.printf("The rectangular moment of inertia is: %.2f",wb2.momentOfInertia);
	System.out.println(" in^4");
	System.out.println("The centroid of the beam is: "+wb2.base+" inches");
	System.out.printf("Using the formula L = (S*I)/(d*c) = (3000*54)/(96*3) , the maximum load that can be placed at the end of the beam is: %.2f",wb2.maxLoad);
	System.out.println(" lbs");
	}
	}