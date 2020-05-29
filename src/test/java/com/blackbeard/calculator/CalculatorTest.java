package com.blackbeard.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
	
	private CalculatorApplication calculator = new CalculatorApplication();
	
	@Test
	public void testSum() {
		assertEquals(5, calculator.sum(2, 3));
	}

}
