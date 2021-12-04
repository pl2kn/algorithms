package com.pl2kn.algorithms.fundamentals;

public class FactorialRecursiveTest extends FactorialTest {

  @Override
  Factorial createFactorial() {
    return new FactorialRecursive();
  }
}
