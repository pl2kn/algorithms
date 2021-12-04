package com.pl2kn.algorithms.fundamentals;

/**
 * Factorial Iterative Implementation.
 */
public class FactorialIterative implements Factorial {

  @Override
  public int factorial(int n) {
    int factorial = 1;
    for (int i = 2; i <= n; i++) {
      factorial *= i;
    }
    return factorial;
  }
}
