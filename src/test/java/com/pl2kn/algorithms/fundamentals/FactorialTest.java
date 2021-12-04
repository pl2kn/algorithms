package com.pl2kn.algorithms.fundamentals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class FactorialTest {

  abstract Factorial createFactorial();

  @Test
  public void One_Test() {
    Factorial factorial = createFactorial();

    assertEquals(1, factorial.factorial(1));
  }

  @Test
  public void Zero_Test() {
    Factorial factorial = createFactorial();

    assertEquals(1, factorial.factorial(0));
  }

  @Test
  public void Five_Test() {
    Factorial factorial = createFactorial();

    assertEquals(120, factorial.factorial(5));
  }

  @Test
  public void Ten_Test() {
    Factorial factorial = createFactorial();

    assertEquals(3628800, factorial.factorial(10));
  }
}
