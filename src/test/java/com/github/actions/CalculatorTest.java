package com.github.actions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

  @Test
  @DisplayName("test sum")
  public void testSum() {
    Calculator calculator = new Calculator();
    int result = calculator.sum(2, 2);
    assertEquals(result, 4);
  }

  @Test
  @DisplayName("test minus")
  public void testMinus() {
    Calculator calculator = new Calculator();
    assertEquals(0, calculator.minus(2, 2));
  }

  @Test
  @DisplayName("test divide")
  public void testDivide() {
    Calculator calculator = new Calculator();
    assertEquals(2, calculator.divide(6, 3));
  }

  @Test
  @DisplayName("test divide on zero")
  public void testDivideWillThrowExceptionWhenDivideOnZero() {
    assertThrows(ArithmeticException.class, () -> {
      Calculator calculator = new Calculator();
      calculator.divide(6, 0);
    });
  }


}
