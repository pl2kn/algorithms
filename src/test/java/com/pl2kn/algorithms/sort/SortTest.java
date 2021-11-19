package com.pl2kn.algorithms.sort;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

abstract class SortTest {

  public abstract Sort createSort();

  @Test
  public void Positive_Ints_Odd_Count_Test() {
    Sort sort = createSort();

    Integer[] array = {1, 3, 9, 7, 6, 2, 8, 5, 0, 4};
    sort.sort(array);

    assertTrue(isSortedAsc(array));
  }

  @Test
  public void Positive_Ints_Even_Count_Test() {
    Sort sort = createSort();

    Integer[] array = {1, 3, 9, 7, 6, 2, 13, 8, 5, 0, 4};
    sort.sort(array);

    assertTrue(isSortedAsc(array));
  }

  @Test
  public void Same_Ints_Test() {
    Sort sort = createSort();

    Integer[] array = {2, 2, 2, 2, 2, 2};
    sort.sort(array);

    assertTrue(isSortedAsc(array));
  }

  @Test
  public void First_Max_Test() {
    Sort sort = createSort();

    Integer[] array = {7, 0, 3, 4, 3, 5, 1};
    sort.sort(array);

    assertTrue(isSortedAsc(array));
  }

  @Test
  public void First_Min_Test() {
    Sort sort = createSort();

    Integer[] array = {0, 1, 3, 4, 3, 5, 7};
    sort.sort(array);

    assertTrue(isSortedAsc(array));
  }

  protected  <T extends Comparable<T>> boolean isSortedAsc(T[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i].compareTo(array[i - 1]) < 0) {
        return false;
      }
    }

    return true;
  }
}
