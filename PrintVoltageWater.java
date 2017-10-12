/**
 * Assignment 1
 * PrintVoltageWater Class
 * The class prints a table showing the meter voltage corresponding to water
 * temperatures varying from 0 °C to 100 °C in increments of 10 degrees.

 * 
 * @author Francis Okoye 100584156
 * @date 11 Oct 2017
 */

import java.text.DecimalFormat;  //this is imported to help organize the decimal places.

public class PrintVoltageWater
{
	public static void main(String args[])
	{
		/**
	 	* this object is created to access the imported decimal format class
	 	* located in the java.text package 
		 */

		DecimalFormat formatter = new DecimalFormat("#00.00"); //a formatter to keep the values at two decimal places.

		int T;
		
		double Vm; //instance variables
		System.out.println("\tT\t Vm\n      _____\t_____"); //printing on a new line, a well organized header b4 the for loop is initialized for the T.
		for (T=0;T<=100;T+=10) //this loop for t going from 0- 100 with an increments of 10.
			
			{
			Vm=(double)(20*T+2000)/(T+250); //The voltage v indicates the temperature (t) of the water according to the equation.
		
			String number = formatter.format(Vm);
			System.out.println("\t"+T+"\t"+number);
			}
	}
}