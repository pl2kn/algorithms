package com.pl2kn.algorithms.fundamentals;

/**
 * Factorial Recursive Implementation.
 */
public class FactorialRecursive implements Factorial {

  @Override
  public int factorial(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    return n * factorial(n - 1);
  }
}
