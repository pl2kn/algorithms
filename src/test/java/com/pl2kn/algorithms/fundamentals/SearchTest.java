package com.pl2kn.algorithms.fundamentals;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class SearchTest {

  abstract Search createSearch();

  @Test
  public void Even_Array_Search() {
    Search binarySearch = createSearch();
    int[] array = {1, 2, 3, 4, 5};
    int target = 3;

    assertEquals(2, binarySearch.search(array, target));
  }

  @Test
  public void Odd_Array_Search() {
    Search binarySearch = createSearch();
    int[] array = {1, 2, 3, 4, 5, 6};
    int target = 3;

    assertEquals(2, binarySearch.search(array, target));
  }

  @Test
  public void One_Item_Array_Search() {
    Search binarySearch = createSearch();
    int[] array = {1};
    int target = 1;

    assertEquals(0, binarySearch.search(array, target));
  }

  @Test
  public void Not_Exist_Item_Array_Search() {
    Search binarySearch = createSearch();
    int[] array = {1, 2, 3, 4, 5, 6};
    int target = 7;

    assertEquals(-1, binarySearch.search(array, target));
  }
}
