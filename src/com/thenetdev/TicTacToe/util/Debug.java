package com.thenetdev.TicTacToe.util;

/**
 * 
 * A basic debugging class, will add more functionality later.
 * 
 * @author Matthew Sowden
 *
 */

public class Debug {
	
	/**
	 * 
	 * Main use of the Debug Class. Used to print messages to console for debugging 
	 * using System.out.println()
	 * 
	 * @param str    Debug message to be printed
	 * @param dt     Debug toggle for easy switching
	 * 
	 * @deprecated  In favour of d().
	 */
	@Deprecated
	public static void result(String str,int dt)
	{
		if(dt == 1)
		{
		System.out.println("[DEBUG] "+str);
		}
	}
	
	/**
	 * 
	 * Successor of the result() method. Does the same thing, but
	 * is shortened to make it much easier to reference.
	 * 
	 * @param dt       Debug Toggle for Easy Switching.
	 * @param str      Debug Message to be Printed.
	 */
	public static void d(int dt, String str){
		
		if(dt == 1){
			System.out.println("[DEBUG]"+str);
		}
		
	}
	
	/**
	 * 
	 * Like result() however this is formatted for mathematical operations.
	 * 
	 * @param dbl    Debug math function to be printed.
	 * @param dt     Debug toggle for easy switching
	 * 
	 * @deprecated  In favour of m()
	 */
	@Deprecated
	public static void math(double dbl, int dt)
	{
		if(dt == 1)
		{
		System.out.println("[DEBUG] "+dbl);
		}
	}
	
	/**
	 * 
	 * Like d() however this is formatted for mathematical operations.
	 * Successor to math()
	 * 
	 * @param dbl    Debug math function to be printed.
	 * @param dt     Debug toggle for easy switching
	 * 
	 */
	public static void m(double dt, double dbl)
	{
		if(dt == 1)
		{
		System.out.println("[DEBUG] "+dbl);
		}
	}
	
}
