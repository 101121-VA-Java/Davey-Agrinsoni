package com.revature;

public class StringDriver {

	public static void main(String[] args) {

		/*
		 * Comparing objects in Java:
		 * 		- == vs .equals
		 * 			- == compares the value in the Stack, used for primitives
		 * 				- if used on reference types, compare the memory address
		 * 			- .equals (if implemented properly) compares the value of the objects as defined in the class
		 * 				- default implementation in the Object class is ==
		 * 					- need to override based on Class fields
		 */

		/*
		 * String methods to be play around with:
		 * 		- substring
		 * 		- replace
		 * 		- chartAt
		 * 		- ...
		 */
		
		StringBuilder sb = new StringBuilder("Hello world!");
		
		System.out.println(sb.reverse());
		
		//generally use string builder
		StringBuffer sbuff = new StringBuffer("Hello");
		
		StringDriver sd = new StringDriver();
		
		System.out.println(sd.removeEveryOtherLetter("Hello World!"));
	}
	
	/*
	 * Using StringBuilder and its associated methods (if needed), 
	 * create a method that removes every other letter of a String passed in 
	 * and return that newly created string.
	 */
	public String removeEveryOtherLetter(String s) {
        StringBuilder test = new StringBuilder();
		for(int i = 0; i < s.length(); i+=2) {
			test.append(s.charAt(i));
			}
		return test.toString();
		}

	/*
	 * Given the string of a url of the format localhost:3500/[controller]/[resource]
	 * where "localhost:3500" is a constant
	 * controller and resource can be any 1 word
	 * return the value of controller as a string
	 */
	public String getControllerValue(String url) {
		return null;
	}

}
