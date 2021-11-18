package com.pl2kn.algorithms.fundamentals;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchIterativeTest extends SearchTest{

  @Override
  Search createSearch() {
    return new BinarySearchIterative();
  }

  @Test
  public void Odd_Array_Middle_Search_Test() {
    Search binarySearch = createSearch();
    int[] array = {1, 2, 3, 4, 5, 6};
    int target = 2;

    assertEquals(1, binarySearch.search(array, target));
  }
}
