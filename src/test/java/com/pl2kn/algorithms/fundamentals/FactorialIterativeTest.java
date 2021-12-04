package com.pl2kn.algorithms.fundamentals;

public class FactorialIterativeTest extends FactorialTest {

  @Override
  Factorial createFactorial() {
    return new FactorialIterative();
  }
}
