package com.pl2kn.algorithms.sort;

/**
 * Selection Sort implementation.
 */
public class SelectionSort extends Sort {

  @Override
  public <T extends Comparable<T>> void sort(T[] array) {
    int n = array.length;

    for (int i = 0; i < n; i++) {
      int minIndex = i;

      for (int j = i; j < n; j++) {
        if (array[j].compareTo(array[minIndex]) < 0) {
          minIndex = j;
        }
      }

      if (minIndex != i) {
        swap(array, i, minIndex);
      }
    }
  }
}
