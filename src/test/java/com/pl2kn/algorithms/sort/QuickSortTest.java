package com.pl2kn.algorithms.sort;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class QuickSortTest extends SortTest {

  @Override
  public Sort createSort() {
    return new QuickSort();
  }

  @Test
  public void Asc_Sorted_Input_Array_Test() {
    Sort sort = createSort();

    Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    sort.sort(array);

    assertTrue(isSortedAsc(array));
  }
}
