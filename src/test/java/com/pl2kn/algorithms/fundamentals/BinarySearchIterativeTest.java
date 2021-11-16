package com.pl2kn.algorithms.fundamentals;

public class BinarySearchIterativeTest extends SearchTest{

  @Override
  Search createSearch() {
    return new BinarySearchIterative();
  }
}
