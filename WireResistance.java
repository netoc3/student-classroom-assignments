/**
 * Assignment 1 question 3
 * WireResistance Class
 * 
 * @author Francis Okoye 100584156
 * @date 11 Oct 2017
 */
import java.util.Scanner;

public class WireResistance 
{
	double rhocopper = 1.678*Math.pow(10, -8); //density of the copper wire
	double rhoaluminum = 2.82*Math.pow(10, -8); //density of the aluminum wire
	/** this takes the wire gauge (n) as argument and returns the diameter of the wire
	*/
	public double computeDiameter(int n)
	{
	double diameter = 0;
	double power = (36-n)/(39.0);
	diameter = 0.127*Math.pow(92, power)*Math.pow(10, -3); //given formula for diameter in meters
	return diameter;
	}
	/** this takes two arguments and returns resistance for copper
	*/
	public double computeCopperWireResistance(double length, int n)
	{
	double diameter= computeDiameter(n);
	double resistance = (4* rhocopper*length)/(Math.PI*Math.pow(diameter,2)); //the given formula for resistance of copper wire 
	return resistance;
	}
	/**this also takes two arguments and returns resistance for aluminum
	*/
	public double computeAluminiumWireResistance(double length, int n)
	{
	double diameter= computeDiameter(n);
	double resistance = (4*rhoaluminum*length)/(Math.PI*Math.pow(diameter,2)); //the given formula for resistance of aluminum wire 
	return resistance;
	}
	public static void main (String args[])
	{
	     Scanner sc = new Scanner(System.in);
	     int n;
	     int length;
	     double resistanceCopper;
	     double resistanceAluminum;
	     double lengthMeters;
	  do{
            System.out.print("Enter the wire gauge(n): ");
            n = sc.nextInt();
            if(n<=0){
            System.out.println("Invalid input value, the wire gauge(n) should have a positive value.");}
	    }
	while(n<=0);
            {
            System.out.print("Enter the wire length in inches : ");
            length = sc.nextInt();
            if(length<=0){
                System.out.println("Invalid input value, the Length should have a positive value.");}
            
	    }
	while(length<=0);
	lengthMeters=0.0254*length;
	WireResistance W = new WireResistance();
	resistanceCopper = W.computeCopperWireResistance(lengthMeters,n);
    resistanceAluminum = W.computeAluminiumWireResistance(lengthMeters,n);
    /**to display the precision of the output resistance to three decimal points.
     */
    resistanceCopper=Double.parseDouble(String.format("%.3f", resistanceCopper));
    resistanceAluminum=Double.parseDouble(String.format("%.3f", resistanceAluminum));
    /** display println for the resistance
     */
    System.out.println("The resistance of a "+ length +" inch piece of "+ n +" gauge copper wire is "+resistanceCopper+" Ohms");
    System.out.println("The resistance of a "+ length +" inch piece of "+ n +" gauge aluminium wire is "+resistanceAluminum+" Ohms");
}

}
