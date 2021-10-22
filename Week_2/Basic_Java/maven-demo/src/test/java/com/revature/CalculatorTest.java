package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.revature.exceptions.CalculatorException;

@TestMethodOrder(OrderAnnotation.class)
public class CalculatorTest {

	private static Calculator cal;

	/*
	 * JUnit Annotations: - @BeforeEach - - @AfterEach - @BeforeAll - @AfterAll
	 * - @Test - @Ignore - @Order
	 */

	@BeforeEach
	public void beforeEach() {
		System.out.println("Running before each test");
	}

	@AfterEach
	public void afterEach() {
		System.out.println("Running after each test");
	}

	@BeforeAll
	public static void setup() {
		cal = new Calculator();
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("AfterAll");
	}

	@Order(1)
	@Test
	public void addOneAndOne() {
		double expected = 2;
		double actual = cal.add(1, 1);
		assertEquals(expected, actual);
	}

	@Order(2)
	@Test
	public void addMinusTwoAndOne() {
		double expected = -1;
		double actual = cal.add(-2, 1);
		assertEquals(expected, actual);
	}

	@Order(3)
	@Test
	public void subFiveAndTwo() {
		double expected = 3;
		double actual = cal.subtract(5,2);
		assertEquals(expected, actual);
	}

	@Order(4)
	@Test
	public void subMinusThreeAndMinusTwo() {
		double expected = -1;
		double actual = cal.subtract(-3,-2);
		assertEquals(expected, actual);
	}
	
	@Order(5)
	@Test
	public void mulFourAndFour() {
		double expected = 16;
		double actual = cal.multiply(4,4);
		assertEquals(expected, actual);
	}
	
	@Order(6)
	@Test
	public void mulMinusFourAndThree() {
		double expected = -12;
		double actual = cal.multiply(-4,3);
		assertEquals(expected, actual);
	}
	
	@Order(7)
	@Test
	public void divFiftyFiveAndEleven() {
		double expected = 5;
		double actual = cal.divide(55,11);
		assertEquals(expected, actual);
	}
	
	@Order(8)
	@Test
	public void divMinusTwentyFourAndEight() {
		double expected = -3;
		double actual = cal.divide(-24,8);
		assertEquals(expected, actual);
	}
	
	@Order(9)
	@Test
	public void divideBy0() {
		assertThrows(CalculatorException.class, () -> cal.divide(1, 0));
	}
	
	@Order(10)
	@Test
	public void checkIfSevenIsPrime() {
		boolean expected = true;
		boolean actual = cal.isPrime(7);
		assertEquals(expected, actual);
	}
	
	@Order(11)
	@Test
	public void checkIfTwelveIsPrime() {
		boolean expected = false;
		boolean actual = cal.isPrime(12);
		assertEquals(expected, actual);
	}
	
	@Order(12)
	@Test
	public void checkIfOneIsPrime() {
		boolean expected = false;
		boolean actual = cal.isPrime(1);
		assertEquals(expected, actual);
	}
	
	@Order(13)
	@Test
	public void checkIfMinusSevenIsPrime() {
		boolean expected = false;
		boolean actual = cal.isPrime(-7);
		assertEquals(expected, actual);
	}
	
	@Order(14)
	@Test
	public void checkIfMinusTwentyFourIsPrime() {
		boolean expected = false;
		boolean actual = cal.isPrime(-24);
		assertEquals(expected, actual);
	}
}
