package com.pl2kn.algorithms.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class SortTest {

  public abstract Sort createSort();

  @Test
  public void Sort_Positive_Ints_Odd_Count() {
    Sort sort = createSort();

    Integer[] array = {1, 3, 9, 7, 6, 2, 8, 5, 0, 4};
    sort.sort(array);

    assertTrue(isSortedAsc(array));
  }

  private <T extends Comparable<T>> boolean isSortedAsc(T[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i].compareTo(array[i - 1]) < 0) {
        return false;
      }
    }

    return true;
  }
}
