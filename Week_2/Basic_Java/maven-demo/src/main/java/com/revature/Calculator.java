package com.revature;

import com.revature.exceptions.CalculatorException;

public class Calculator {

	/*
	 * Should be able to
	 * 	- add
	 * 	- subtract
	 * 	- multiply
	 * 	- divide
	 * 		- throw Calculator Exception (Runtime) when attempting to divide by 0
	 *	- isPrime: checks if a number is Prime
	 */
	
	public double add(double x, double y) {
		return x + y;
	}
	
	public double subtract(double x, double y) {
		return x - y;
	}
	
	public double multiply(double x, double y) {
		return x * y;
	}
	
	public double divide(double x, double y) {
		if(y == 0) {
			throw new CalculatorException();
		}
		return x / y;
	}
	
	public boolean isPrime(int i) {
		//Logic
		boolean b = false; 
		int j = i /2;
		if(i <= 1) { //0 and 1 are not considered Prime. Negatives are also not prime.
			return b; 
		}
		for(int l = 2; l <= j; l++) {
			if(i % l == 0 ) {
				b = false;
			}
			else {
				b = true;
			}
		}
		return b;
	}
}
