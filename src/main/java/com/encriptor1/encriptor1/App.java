package com.encriptor1.encriptor1;

/**
 * Writen by Pinchas Segal
 * made as tar1 of Ofek java traiining program
 */

public class App {


	public static void main( String[] args ) {
		try {			
			GUI.run();																					
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}    	
	}
}
